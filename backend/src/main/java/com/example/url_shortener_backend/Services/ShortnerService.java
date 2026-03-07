package com.example.url_shortener_backend.Services;

import com.example.url_shortener_backend.Entity.Shortner;
import com.example.url_shortener_backend.repository.ShortnerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShortnerService {
    private final ShortnerRepository shortnerRepository;

    public ShortnerService(ShortnerRepository shortnerRepository) {
        this.shortnerRepository = shortnerRepository;
    }
    public String getSomething(){
        return "Hello how are you?";
    }
    public void AddData(){
        Shortner shortner = new Shortner(null,"google.com",437,"abcd321","jhdj/wb124",new Date(),null);
        shortnerRepository.save(shortner);
    }
}
