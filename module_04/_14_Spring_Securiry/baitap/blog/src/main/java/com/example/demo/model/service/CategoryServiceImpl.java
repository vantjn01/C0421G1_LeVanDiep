package com.example.demo.model.service;

import com.example.demo.model.bean.Category;
import com.example.demo.model.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepo iCategoryRepo;

    @Override
    public List<Category> findAll() {
        return this.iCategoryRepo.findAll();
    }


    @Override
    public Category findById(Integer id) {
        return this.iCategoryRepo.findById(id).get();
    }

    @Override
    public void save(Category category) {
        this.iCategoryRepo.save(category);
    }

    @Override
    public void remove(Integer id) {
        this.iCategoryRepo.deleteById(id);
    }
}
