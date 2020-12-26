package com.springcloudd.services;

import com.springcloudd.dao.FormateurRepository;
import com.springcloudd.entities.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EnseignantServiceImpl implements IEnseignantService{
    @Autowired
    private FormateurRepository formateurRepository;
    @Override
    public Formateur save(Formateur formateur) {
        return formateurRepository.save(formateur);
    }
}
