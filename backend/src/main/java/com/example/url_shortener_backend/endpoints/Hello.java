package com.example.url_shortener_backend.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello Worldabcd";
    }
}