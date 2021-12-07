package com.example.demo.service;

import com.example.demo.dto.ListCartDto;
import com.example.demo.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    List<Food>searchListFood(String keySearch);
    Page<Food> getListFood(Pageable pageable);
    List<Food> findAll();
    Food getFoodById(Long foodId);
    Food saveOrder(ListCartDto listCartDto, String username);
}
