package com.example.webfastfood.service;


import com.example.webfastfood.entity.about_account.Account;

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
