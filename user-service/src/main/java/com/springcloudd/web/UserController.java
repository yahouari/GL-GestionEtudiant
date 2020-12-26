package com.springcloudd.web;

import com.springcloudd.dao.UtiliseurRepository;
import com.springcloudd.entities.Etudiant;
import com.springcloudd.entities.Formateur;
import com.springcloudd.entities.Utilisateur;
import com.springcloudd.services.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IEtudiantService iEtudiantService;
    @Autowired
    private IEnseignantService iEnseignantService;
    @Autowired
    private IUtilisateurService iUtilisateurService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private UtiliseurRepository utiliseurRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/users")
    @CrossOrigin("*")
    public List<Utilisateur> getUsers()
    {
        return utiliseurRepository.findAll();

    }

    @PostMapping("/register")
    @CrossOrigin("*")
    public Utilisateur saveEtudiant( @RequestBody UserForm userForm)
    {
        if (userForm.getRole()=="true")
        {  /* String username=userForm.getUsername();
            String email=userForm.getEmail();
            String password=userForm.getPassword(); String repassword=userForm.getConfirmedPassword();
            Date date =userForm.getDate();
            Etudiant etudiant=new Etudiant();
            etudiant.setUsername(username);
            etudiant.setEmail(email);
            etudiant.setPassword(password);
            etudiant.setDateDeNaissance(date);
            return  accountService.saveUser(etudiant);*/
            return  accountService.saveUser(userForm.getUsername(),bCryptPasswordEncoder.encode(userForm.getPassword()),userForm.getConfirmedPassword(),"ETUDIANT",userForm.getDate(),userForm.getEmail());


        }
        else{

            return  accountService.saveUserF(userForm.getUsername(),bCryptPasswordEncoder.encode(userForm.getPassword()),userForm.getConfirmedPassword(),"PROF",userForm.getDate(),userForm.getEmail());



        }

    }


    @GetMapping("/findByUsername/{username}")
    @CrossOrigin("*")
    public Utilisateur findEtudiant(@PathVariable String username)
    {
         return iUtilisateurService.findUtilisateur(username).orElse(null);
    }
}
@Data
class UserForm
{
    private String username;
    private String password;
    private String confirmedPassword;
    private String role;
    private Date date;
    private String email;
}
