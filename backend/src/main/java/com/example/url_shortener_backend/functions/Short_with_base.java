package com.example.url_shortener_backend.functions;

import com.example.url_shortener_backend.Entity.Shortner;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

public record Short_with_base(long id, String user_url, LocalDate created_at, LocalDate expired_at,String url) {
    public Short_with_base{

    }
    public Short_with_base(Shortner shortner,String url) {
        this(shortner.getId(),shortner.getUser_url(),shortner.getCreated_at(),shortner.getExpiry_at(),url);
    }
}
