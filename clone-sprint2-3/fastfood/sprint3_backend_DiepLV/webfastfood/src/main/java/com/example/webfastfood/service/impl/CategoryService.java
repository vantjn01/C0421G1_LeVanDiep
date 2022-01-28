package com.example.webfastfood.service.impl;

import com.example.webfastfood.entity.food.Category;
import com.example.webfastfood.repository.ICategoryRepository;
import com.example.webfastfood.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> list() {
        return this.iCategoryRepository.listAllCategory();
    }

    @Override
    public Optional<Category> findId(int id) {
        return this.iCategoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        this.iCategoryRepository.saveCategory(category.getCategoryCode(), category.getCategoryName());
    }

    @Override
    public void delete(int id) {
        this.iCategoryRepository.deleteCategory(id);
    }

    @Override
    public Optional<Category> findById(int id) {
        return this.iCategoryRepository.findById(id);
    }

    @Override
    public void update(Category category) {
        this.iCategoryRepository.updateCategory(category.getCategoryName(), category.getCategoryCode(), category.getCategoryId());
    }
}
