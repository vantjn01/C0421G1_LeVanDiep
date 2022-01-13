package com.example.webfastfood.service;

import com.example.webfastfood.dto.CartDto;
import com.example.webfastfood.entity.oders.OrderFood;

import java.util.List;

public interface IOrdersService {
    void saveOrderFoodDto(CartDto cartDto);

    List<OrderFood> getInfoOrderFood(String username);
}
