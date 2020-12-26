package com.springcloudd.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    @Id
    private String nom;
    @OneToMany(mappedBy = "theme")
    @JsonIgnore
    private List<Cours> coursList;

    @Override
    public String toString() {
        return "Theme{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
