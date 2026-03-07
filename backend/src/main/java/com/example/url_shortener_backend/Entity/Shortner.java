package com.example.url_shortener_backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Shortner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_url;

    @Column(unique = true)
    private Integer generated_integer;

    private String converted_62;

    private String generated_link;

    private Date created_at;

    private Date expiry_at;
}
