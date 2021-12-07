package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public void saveAccount(Account account) {
        accountRepository.saveAccount(account.getUsername(), account.getPassword());
    }


    @Override
    public void editAccount(Account account) {
        accountRepository.editAccount(account.getUsername(), account.getPassword(), account.getAccountRoleId());
    }

    @Override
    public void saveRoleForAccount(Long accountId, Long roleId) {
        accountRepository.saveRoleForAccount(accountId, roleId);
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.getAccountList();
    }




    @Override
    public Optional<Account> findByUserNames(String username) {
        return accountRepository.findByUserNames(username);
    }

    @Override
    public Long getAccountByUsernameDto(String username) {
        return accountRepository.getAccountByUsernameDto(username);
    }

    @Override
    public void changePassWord(String newPassword,Long accountId) {
        accountRepository.changePassWord(encoder.encode(newPassword), accountId);
    }

    @Override
    public void changeStatus(int status, Long accountId) {
        accountRepository.changeStatus(status, accountId);
    }

//    @Override
//    public void editAccount(Account account) {
//        accountRepository.editAccount(account.getUsername(), account.getPassword(), account.getAccountId());
//    }
}
