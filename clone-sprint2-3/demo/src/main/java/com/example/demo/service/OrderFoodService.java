package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.OrderFood;

import java.util.List;

public interface OrderFoodService {
    void saveOrderFoodDto(CartDto cartDto);

    List<OrderFood> getInfoOrderFood(String username);
}
