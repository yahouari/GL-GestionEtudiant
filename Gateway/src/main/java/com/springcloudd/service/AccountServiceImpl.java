package com.springcloudd.service;

import com.springcloudd.entities.AppRole;
import com.springcloudd.entities.AppUser;

import com.springcloudd.entities.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;

    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword, String Role, Date Date, String email) {
        AppUser user=userService.findEtudiant(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        UserForm userForm=new UserForm(username,bCryptPasswordEncoder.encode(password),bCryptPasswordEncoder.encode(password),Role,Date,email);

        return userService.saveEtudiant(userForm);
    }

    @Override
    public AppRole save(AppRole role) {
        return null;
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return userService.findEtudiant(username);
    }


}
