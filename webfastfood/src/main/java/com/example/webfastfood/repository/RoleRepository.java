package com.example.webfastfood.repository;

import com.example.webfastfood.entity.about_account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT into account_role (account_id,role_id) values (?1,1);", nativeQuery = true)
    void saveRole(Long accountId);

}
