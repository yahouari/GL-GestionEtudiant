package com.springcloudd.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String nom;
    private Difficulte difficulte;
    private int nombreDePlace;
    private String prerequis;
    @ElementCollection
    private List<String> formateurList=new ArrayList<>();
    @ElementCollection
    private List<Long> inscriptions;
    @ManyToOne
    private Theme theme;
    @OneToOne
    private Calendrier calendrier;
    private byte[] photo;
}
