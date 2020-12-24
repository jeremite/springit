package com.travis.springit.service;

import com.travis.springit.domain.Role;
import com.travis.springit.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {


    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;  //autowire RoleRepository
    }
    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
