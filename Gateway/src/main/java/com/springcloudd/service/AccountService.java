package com.springcloudd.service;


import com.springcloudd.entities.AppRole;
import com.springcloudd.entities.AppUser;

import java.util.Date;

public interface AccountService {
    public AppUser saveUser(String username, String password, String confirmedPassword, String Role, Date Date, String email);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);

}
