package com.springcloudd.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("E")
public class Etudiant extends Utilisateur{
   @ElementCollection
    private List<Long> inscriptions;
   
}
