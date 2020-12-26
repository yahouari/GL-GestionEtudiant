package com.springcloudd.services;


import com.springcloudd.dao.RoleRepository;
import com.springcloudd.dao.UtiliseurRepository;
import com.springcloudd.entities.Role;
import com.springcloudd.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService {
    @Autowired
    private UtiliseurRepository utiliseurRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Utilisateur utilisateur) {
        
        utiliseurRepository.save(utilisateur);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void addRoleToUtilisateur(String role, String utilisateur) {
        Utilisateur utilisateur1=utiliseurRepository.findById(utilisateur).orElse(null);
        assert utilisateur1!=null;
        Role role1=roleRepository.findByNom(role);
        utilisateur1.getRoles().add(role1);
        utiliseurRepository.save(utilisateur1);

    }

    @Override
    public Optional<Utilisateur> findUtilisateur(String username) {
        return utiliseurRepository.findById(username);
    }
}
