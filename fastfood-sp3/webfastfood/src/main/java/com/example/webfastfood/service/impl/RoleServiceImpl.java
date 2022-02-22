package com.example.webfastfood.service.impl;

import com.example.webfastfood.entity.about_account.Role;
import com.example.webfastfood.repository.RoleRepository;
import com.example.webfastfood.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveRole(Role role) {

    }
}
