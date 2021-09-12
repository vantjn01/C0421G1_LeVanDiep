package com.example.demo.model.service;

import com.example.demo.model.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

   Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
