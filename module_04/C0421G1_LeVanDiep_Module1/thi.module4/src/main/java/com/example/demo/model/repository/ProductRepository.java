package com.example.demo.model.repository;

import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

}
