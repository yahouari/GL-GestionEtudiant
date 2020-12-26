package com.springcloudd.services;

import com.springcloudd.entities.Role;

public interface IRoleService {
    public Role save(Role role);
    Role findByNom(String nom);
}
