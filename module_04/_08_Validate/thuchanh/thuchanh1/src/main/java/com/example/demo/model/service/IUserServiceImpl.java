package com.example.demo.model.service;

import com.example.demo.model.entity.User;
import com.example.demo.model.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IUserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public void createUser(User user) {
        this.iUserRepository.save(user);
    }
}
