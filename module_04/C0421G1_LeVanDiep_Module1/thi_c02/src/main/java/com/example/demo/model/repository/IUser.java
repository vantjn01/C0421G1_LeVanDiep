package com.example.demo.model.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
