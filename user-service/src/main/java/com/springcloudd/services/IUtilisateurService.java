package com.springcloudd.services;


import com.springcloudd.entities.Role;
import com.springcloudd.entities.Utilisateur;

import java.util.Optional;

public interface IUtilisateurService {
    public void save(Utilisateur utilisateur);
    public void saveRole(Role role);
    public void addRoleToUtilisateur(String role,String utilisateur);
    public Optional<Utilisateur> findUtilisateur(String username);
}
