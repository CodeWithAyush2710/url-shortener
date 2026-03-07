package com.example.url_shortener_backend.Controller;

import com.example.url_shortener_backend.Services.ShortnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortnerController {
    private final ShortnerService shortnerService;
    public ShortnerController(ShortnerService shortnerService) {
        this.shortnerService = shortnerService;
    }

    @GetMapping("/api")
    public String getSomething() {
        shortnerService.AddData();
        return shortnerService.getSomething();
    }
}
