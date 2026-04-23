package com.example.url_shortener_backend.Controller;

import com.example.url_shortener_backend.Entity.Shortner;
import com.example.url_shortener_backend.functions.Short_with_base;
import com.example.url_shortener_backend.functions.url;
import com.example.url_shortener_backend.Services.ShortnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortnerController {
    private final ShortnerService shortnerService;
    public ShortnerController(ShortnerService shortnerService) {
        this.shortnerService = shortnerService;
    }

    @PostMapping("/get")
    public Short_with_base getShortner(@RequestBody url url) {
        return shortnerService.getShortner(url.url());
    }
    @GetMapping("{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        String originalUrl = shortnerService.getOriginalUrl(shortCode);

        if (originalUrl == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(302) // temporary redirect
                .header("Location", originalUrl)
                .build();
    }
}
