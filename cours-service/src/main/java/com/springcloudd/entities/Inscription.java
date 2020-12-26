package com.springcloudd.entities;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Inscription {
    private Long id;
    private Date date;
    private boolean validation;
    private Long idCours;

    private String nameEtudiant;
}
