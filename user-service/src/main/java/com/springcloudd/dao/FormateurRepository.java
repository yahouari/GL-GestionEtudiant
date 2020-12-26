package com.springcloudd.dao;


import com.springcloudd.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur,String> {
}
