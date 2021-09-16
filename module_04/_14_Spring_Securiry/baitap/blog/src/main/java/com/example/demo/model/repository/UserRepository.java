package com.example.demo.model.repository;

import com.example.demo.model.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
