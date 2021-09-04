package com.example.demo.model.service;

import com.example.demo.model.bean.Category;
import com.example.demo.model.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findAll() {
        return this.iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return this.iCategoryRepository.findById(id).get();
    }

    @Override
    public void save(Category category) {
        this.iCategoryRepository.save(category);

    }

    @Override
    public void remove(Integer id) {
        this.iCategoryRepository.deleteById(id);

    }
}
