package com.springcloudd.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@ToString
@DiscriminatorColumn(name = "USER_TYPE")
public class Utilisateur {
    @Id
    private String username;
    private String adresse;
    private String cin;
    @Temporal(value = TemporalType.DATE)
    private Date dateDeNaissance;
    private String email;
    private String nom;
    private String prenom;
    private byte[] photo;
    private String password;
@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Role> roles=new ArrayList<>();
    private int tel;

    public Utilisateur(Utilisateur utilisateur) {
        this.username=utilisateur.username;
        this.adresse=utilisateur.adresse;
        this.cin=utilisateur.cin;
        this.dateDeNaissance=utilisateur.dateDeNaissance;
        this.email=utilisateur.email;
        this.nom=utilisateur.nom;
        this.prenom=utilisateur.prenom;
        this.password=utilisateur.password;
        this.roles=utilisateur.roles;
        this.tel=utilisateur.tel;
        this.photo=utilisateur.photo;
    }
}
