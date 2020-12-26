package com.springcloudd.service;

import com.springcloudd.entities.AppUser;
import com.springcloudd.entities.UserForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("USER-SERVICE")
public interface UserService {
    @PostMapping("/register")
    public AppUser saveEtudiant(@RequestBody UserForm userForm);
    @GetMapping("/findByUsername/{username}")
    public AppUser findEtudiant(@PathVariable String username);

}
