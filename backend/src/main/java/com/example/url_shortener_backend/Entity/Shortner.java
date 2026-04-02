package com.example.url_shortener_backend.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Shortner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_url;

    private LocalDate created_at;

    private LocalDate expiry_at;

    // No-args constructor
    public Shortner() {
    }

    // All-args constructor
    public Shortner(Long id, String user_url, LocalDate created_at, LocalDate expiry_at) {
        this.id = id;
        this.user_url = user_url;
        this.created_at = created_at;
        this.expiry_at = expiry_at;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_url() {
        return user_url;
    }

    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getExpiry_at() {
        return expiry_at;
    }

    public void setExpiry_at(LocalDate expiry_at) {
        this.expiry_at = expiry_at;
    }

    @Override
    public String toString() {
        return "Shortner{" +
                "id=" + id +
                ", user_url='" + user_url + '\'' +
                ", created_at=" + created_at +
                ", expiry_at=" + expiry_at +
                '}';
    }
}
