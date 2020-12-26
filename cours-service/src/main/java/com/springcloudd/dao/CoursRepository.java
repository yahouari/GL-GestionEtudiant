package com.springcloudd.dao;



import com.springcloudd.entities.Cours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CoursRepository extends JpaRepository<Cours,Long> {
    Page<Cours> findByNomContains(String mc, Pageable pageable);
    Cours findByInscriptionsIsContaining(Long id);
    Cours findByFormateurListIsContaining(String username);
}
