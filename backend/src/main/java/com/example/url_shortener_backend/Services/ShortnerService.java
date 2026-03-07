package com.example.url_shortener_backend.Services;

import com.example.url_shortener_backend.Entity.Shortner;
import com.example.url_shortener_backend.functions.Short_with_base;
import com.example.url_shortener_backend.functions.url;
import com.example.url_shortener_backend.repository.ShortnerRepository;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ShortnerService {
    private final Hashids hashids;
    private final ShortnerRepository shortnerRepository;
    private final long offset = 14776336;

    public ShortnerService(ShortnerRepository shortnerRepository, Hashids hashids) {
        this.shortnerRepository = shortnerRepository;
        this.hashids = hashids;
    }

    public Short_with_base getShortner(String str){
        Shortner shortner = shortnerRepository.save(new Shortner(null,str, LocalDate.now(), LocalDate.now().plusMonths(3)));
        String hash = hashids.encode(shortner.getId());
        return new Short_with_base(shortner,hash);
    }

    public url checkShortner(String url){
        long id = hashids.decode(url)[0];
        Optional<Shortner> shortner = shortnerRepository.findById(id);

        return ((shortner.isPresent()) ? new url(shortner.get().getUser_url()):new url("No url present for this"));
    }
}
