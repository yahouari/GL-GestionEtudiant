package com.springcloudd.services;

import com.springcloudd.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public void saveInscription(Long id,String username);
    public Etudiant save(Etudiant etudiant);
    public Etudiant getEtudiant(String username);

}
