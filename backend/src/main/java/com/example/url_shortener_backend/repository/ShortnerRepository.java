package com.example.url_shortener_backend.repository;

import com.example.url_shortener_backend.Entity.Shortner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortnerRepository extends JpaRepository<Shortner, Long> {
}
