package com.example.webfastfood.service;

import com.example.webfastfood.entity.food.Category;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    List<Category> list();

    Optional<Category> findId(int id);

    void save(Category category);

    void delete(int id);

    Optional<Category> findById(int id);

    void update(Category category);
}
