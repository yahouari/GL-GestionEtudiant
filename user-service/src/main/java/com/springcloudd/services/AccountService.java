package com.springcloudd.services;

import com.springcloudd.entities.Etudiant;
import com.springcloudd.entities.Role;
import com.springcloudd.entities.Utilisateur;

import java.util.Date;

public interface AccountService {
/*
    public Utilisateur saveUser(Etudiant etudiant);
*/
    public Utilisateur saveUser(String username, String password, String confirmedPassword, String Role, Date Date, String email);

    Utilisateur loadUserByUsername(String username);
    public Role saveRole(Role role);
    public Utilisateur saveUserF(String username, String password, String confirmedPassword, String Role, Date Date, String email);

}
