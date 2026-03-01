package com.example.url_shortener_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlShortenerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerBackendApplication.class, args);
		System.out.println("Server started");
	}

}
