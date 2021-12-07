package com.example.demo.service;

import com.example.demo.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    void saveAccount(Account account);


    void editAccount(Account account);


    void saveRoleForAccount(Long accountId, Long roleId);


    List<Account> getAccountList();


    Optional<Account> findByUserNames(String username);

    Long getAccountByUsernameDto(String username);

    void changePassWord(String newPassword,Long accountId);

    void changeStatus(int Status, Long accountId);

}
