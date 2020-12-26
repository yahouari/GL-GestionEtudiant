package com.springcloudd.dao;


import com.springcloudd.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,String> {

}
