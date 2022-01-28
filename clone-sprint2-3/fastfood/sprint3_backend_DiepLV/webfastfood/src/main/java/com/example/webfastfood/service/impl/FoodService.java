package com.example.webfastfood.service.impl;

import com.example.webfastfood.entity.food.Food;
import com.example.webfastfood.repository.IFoodRepository;
import com.example.webfastfood.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private IFoodRepository iFoodRepository;

    @Override
    public List<Food> list() {
        return this.iFoodRepository.listAllFood();
    }

    @Override
    public Optional<Food> findById(int id) {
        return this.iFoodRepository.FoodById(id);
    }

    @Override
    public List<Food> findFoodCategory(int id) {
        return this.iFoodRepository.findFoodByCategory(id);
    }

    @Override
    public List<Food> sortFoodAToZ() {
        return this.iFoodRepository.sortFoodAtoZ();
    }

    @Override
    public void create(Food food) {
        this.iFoodRepository.createFood(food.getFadCode(), food.getFadImage(), food.getFadName(), food.getFadPrice(), food.getCategory().getCategoryId());
    }

    @Override
    public void update(Food food) {
        this.iFoodRepository.updateFood(food.getFadCode(), food.getFadImage(), food.getFadName(), food.getFadPrice(), food.getCategory().getCategoryId(), food.getFadId());
    }

    @Override
    public List<Food> listTrend() {
        return this.iFoodRepository.listEight();
    }

    @Override
    public void deleteFood(int id) {
        this.iFoodRepository.deleteFood(id);
    }


}
