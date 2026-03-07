package com.example.url_shortener_backend.Controller;

import com.example.url_shortener_backend.Entity.Shortner;
import com.example.url_shortener_backend.functions.Short_with_base;
import com.example.url_shortener_backend.functions.url;
import com.example.url_shortener_backend.Services.ShortnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/check")
    public url checkShortner(@RequestBody url url) {
        return shortnerService.checkShortner(url.url());
    }
}
