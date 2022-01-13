package com.example.webfastfood.service;

import com.example.webfastfood.dto.ListCartDto;
import com.example.webfastfood.entity.food.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IFoodService {
    List<Food>searchListFood(String keySearch);
    Page<Food> getListFood(Pageable pageable);
    List<Food>findAll();
    Food getFoodById(Long foodId);



    Food saveOrder(ListCartDto listCartDto, String username);

}
