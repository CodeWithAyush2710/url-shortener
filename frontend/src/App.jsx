import { useState } from 'react'
import './App.css'

function App() {
  const [originalUrl, setOriginalUrl] = useState('')
  const [shortUrl, setShortUrl] = useState('')
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')
  const [copied, setCopied] = useState(false)

  const handleShortenUrl = async () => {
    if (!originalUrl.trim()) {
      setError('Please enter a valid URL')
      return
    }

    setLoading(true)
    setError('')
    setShortUrl('')
    setCopied(false)

    try {
      const response = await fetch(import.meta.env.VITE_API_URL + '/get' || 'http://localhost:8080/get', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ url: originalUrl }),
      })

      if (!response.ok) {
        throw new Error('Failed to shorten URL')
      }

      const data = await response.json()
      setShortUrl(data.url)
    } catch (err) {
      setError(err.message || 'Something went wrong. Please try again.')
      setShortUrl('')
    } finally {
      setLoading(false)
    }
  }

  const handleCopyToClipboard = () => {
    navigator.clipboard.writeText(shortUrl)
    setCopied(true)
    setTimeout(() => setCopied(false), 2000)
  }

  const handleKeyPress = (e) => {
    if (e.key === 'Enter') {
      handleShortenUrl()
    }
  }

  return (
    <div className="container">
      <div className="card">
        <h1 className="title">URL Shortener</h1>
        
        <div className="input-section">
          <input
            type="text"
            placeholder="Enter your long URL here"
            value={originalUrl}
            onChange={(e) => setOriginalUrl(e.target.value)}
            onKeyPress={handleKeyPress}
            className="url-input"
            disabled={loading}
          />
        </div>

        <div className="button-section">
          <button
            onClick={handleShortenUrl}
            className="get-url-btn"
            disabled={loading}
          >
            {loading ? 'Shortening...' : 'GET URL'}
          </button>
        </div>

        {error && <div className="error-message">{error}</div>}

        {shortUrl && (
          <div className="result-section">
            <div className="result-label">Your Shortened URL:</div>
            <div className="short-url-container">
              <span className="short-url">{shortUrl}</span>
              <button
                onClick={handleCopyToClipboard}
                className="copy-btn"
                title="Copy to clipboard"
              >
                {copied ? '✓ Copied!' : '📋 Copy'}
              </button>
            </div>
          </div>
        )}
      </div>
    </div>
  )
}

export default App
