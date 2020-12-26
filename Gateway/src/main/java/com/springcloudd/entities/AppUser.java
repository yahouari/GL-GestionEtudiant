package com.springcloudd.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class AppUser {
    private String username;
    private String adresse;
    private String cin;

    private Date dateDeNaissance;
    private String email;
    private String nom;
    private String prenom;
    private byte[] photo;
    private String password;

    private List<AppRole> roles=new ArrayList<>();
    private int tel;
}
