package com.example.demo.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*File này dùng để tạo pass đã được mã hóa*/
public class CreateBCryptPass {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("12345"));
    }
}

