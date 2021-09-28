package com.example.demo.model.repository;

import com.example.demo.model.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    List<ProductType> findAll();

}
