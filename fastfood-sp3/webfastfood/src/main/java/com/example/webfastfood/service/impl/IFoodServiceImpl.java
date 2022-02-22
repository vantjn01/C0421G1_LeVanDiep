package com.example.webfastfood.service.impl;

import com.example.webfastfood.dto.ListCartDto;
import com.example.webfastfood.entity.food.Food;
import com.example.webfastfood.repository.IFoodRepository;
import com.example.webfastfood.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IFoodServiceImpl implements IFoodService {
    @Autowired
    IFoodRepository foodRepository;


    @Override
    public List<Food> searchListFood(String keySearch) {
        return foodRepository.searchListFood(keySearch);
    }

    @Override
    public Page<Food> getListFood(Pageable pageable) {
        return foodRepository.getListFood(pageable);
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(Long foodId) {
        return foodRepository.getFoodById(foodId);
    }

    @Override
    public Food saveOrder(ListCartDto listCartDto, String username) {
        return null;
    }

}
