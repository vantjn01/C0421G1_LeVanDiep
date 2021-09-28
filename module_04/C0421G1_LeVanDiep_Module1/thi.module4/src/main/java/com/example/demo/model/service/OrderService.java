package com.example.demo.model.service;

import com.example.demo.model.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService {
    Optional<Order> findById(Long id);



    void save(Order order);




    Page<Order> findAll(Pageable pageable);
}
