package com.springcloudd.services;

import com.springcloudd.dao.RoleRepository;
import com.springcloudd.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByNom(String nom) {
        return roleRepository.findByNom(nom);
    }
}
