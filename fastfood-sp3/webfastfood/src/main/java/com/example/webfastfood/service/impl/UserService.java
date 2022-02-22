package com.example.webfastfood.service.impl;


import com.example.webfastfood.entity.about_account.Account;
import com.example.webfastfood.repository.IUserRepository;
import com.example.webfastfood.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<Account> findAll() {
        return this.iUserRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return this.iUserRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Account account) {
        iUserRepository.save(account);
    }

    @Override
    public void remove(Long id) {
        iUserRepository.deleteById(id);
    }
}