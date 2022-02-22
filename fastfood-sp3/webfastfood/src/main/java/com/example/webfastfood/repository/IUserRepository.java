package com.example.webfastfood.repository;


import com.example.webfastfood.entity.about_account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Account,Long> {



    @Query(value = "select * from account where account_username = ?1 ", nativeQuery = true)
    Optional<Account> findByUserNames(String userName);



}