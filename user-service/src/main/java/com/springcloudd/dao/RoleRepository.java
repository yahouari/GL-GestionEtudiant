package com.springcloudd.dao;


import com.springcloudd.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByNom(String nom);

}
