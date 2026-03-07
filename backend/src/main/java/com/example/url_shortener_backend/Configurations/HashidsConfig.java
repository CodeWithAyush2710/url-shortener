package com.example.url_shortener_backend.Configurations;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HashidsConfig {
    @Value("${hashids.text}")
    private String text;
    @Value("${hashids.min-length}")
    private int minLength;

    @Bean
    public Hashids hashids() {
        return new Hashids(text,minLength);
    }
}
