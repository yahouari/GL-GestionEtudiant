package com.springcloudd.dao;


import com.springcloudd.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtiliseurRepository extends JpaRepository<Utilisateur,String> {

    Page<Utilisateur> findAllByUsername(String username, Pageable pageable);

}
