package com.example.demo.repositories;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT into account_role (account_id,role_id) values (?1,1);", nativeQuery = true)
    void saveRole(Long accountId);

}
