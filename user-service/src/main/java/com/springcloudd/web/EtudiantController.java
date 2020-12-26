package com.springcloudd.web;

import com.springcloudd.entities.Etudiant;
import com.springcloudd.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EtudiantController {
    @Autowired
    private IEtudiantService iEtudiantService;
    @CrossOrigin("*")
    @PostMapping("/saveInscription/{etudiant}:{id}")
    public void saveInscription(@PathVariable("id") Long id, @PathVariable("etudiant") String username)
    {
            System.out.println(id);
            iEtudiantService.saveInscription(id,username);
    }
    @CrossOrigin("*")
    @GetMapping("/etudiant/{name}")
    public Etudiant getEtudiant(@PathVariable("name") String username)
    {
        return iEtudiantService.getEtudiant(username);
    }

}
