package com.springcloudd.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendrier {
    @Id
    private Long id;
    @Temporal(value = TemporalType.DATE)
    private Date date_debut;
    @Temporal(value = TemporalType.DATE)
    private Date dateFin;
    @OneToMany
    private Collection<Horaire> horaires;

}
