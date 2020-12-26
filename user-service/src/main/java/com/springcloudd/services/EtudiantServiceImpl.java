package com.springcloudd.services;

import com.springcloudd.dao.EtudiantRepository;
import com.springcloudd.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public void saveInscription(Long id,String username) {
        Etudiant etudiant=etudiantRepository.findById(username).orElse(null);
        assert etudiant != null;
        etudiant.getInscriptions().add(id);
        etudiantRepository.save(etudiant);
        System.out.println("dezt");
    }

    @Override
    public Etudiant save(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiant(String username) {
        return etudiantRepository.findById(username).orElse(null);
    }
}
