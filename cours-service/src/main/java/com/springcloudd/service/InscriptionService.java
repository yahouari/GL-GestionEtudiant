package com.springcloudd.service;

import com.springcloudd.entities.Inscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("INSCRIPTION-SERVICE")
public interface InscriptionService {
    @GetMapping("/inscription/{id}")
    public String getnameEtudiant(@PathVariable Long id );
}
