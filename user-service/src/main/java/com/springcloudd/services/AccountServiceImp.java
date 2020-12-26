package com.springcloudd.services;

import com.springcloudd.entities.Etudiant;
import com.springcloudd.entities.Formateur;
import com.springcloudd.entities.Role;
import com.springcloudd.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImp implements AccountService{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IEnseignantService iEnseignantService;
    @Autowired
    private IEtudiantService iEtudiantService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IUtilisateurService iUtilisateurService;
    @Override
    public Utilisateur saveUser(String username, String password, String confirmedPassword, String Role, Date Date, String email) {
        Etudiant etudiant=new Etudiant();

        etudiant.setUsername(username);
        etudiant.setPassword(password);
        etudiant.setDateDeNaissance(Date);
        etudiant.setEmail(email);
        etudiant.getRoles().add(iRoleService.findByNom(Role));
        iEtudiantService.save(etudiant);
        return etudiant;
            /*System.out.println("TEST");

        String hashPW=bCryptPasswordEncoder.encode(etudiant.getPassword());

            etudiant.setPassword(hashPW);
            return iEtudiantService.save(etudiant);*/

    }
    @Override
    public Utilisateur saveUserF(String username, String password, String confirmedPassword, String Role, Date Date, String email) {
        System.out.println("TEST1");
        Formateur prof=new Formateur();

        prof.setUsername(username);
        prof.setPassword(password);
        prof.setDateDeNaissance(Date);
        prof.setEmail(email);
        prof.getRoles().add(iRoleService.findByNom(Role));
        iEnseignantService.save(prof);
        return prof;

    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return iUtilisateurService.findUtilisateur(username).orElse(null);
    }

    @Override
    public Role saveRole(Role role) {
        return iRoleService.save(role);
    }
}
