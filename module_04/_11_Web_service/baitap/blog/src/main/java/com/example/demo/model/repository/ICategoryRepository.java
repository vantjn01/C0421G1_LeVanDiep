package com.example.demo.model.repository;

import com.example.demo.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
