package com.example.webfastfood.service.impl;

import com.example.webfastfood.dto.CartDto;
import com.example.webfastfood.entity.oders.OrderFood;
import com.example.webfastfood.repository.IOrderRepository;
import com.example.webfastfood.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrdersServiceImpl implements IOrdersService {
    @Autowired
    IOrderRepository orderFoodRepository;

    @Override
    public void saveOrderFoodDto(CartDto cartDto) {
        orderFoodRepository.saveOrderFoodDto(cartDto.getFoodId(),cartDto.getQuantity(),cartDto.getOrdersId());
    }

    @Override
    public List<OrderFood> getInfoOrderFood(String username) {
        return orderFoodRepository.getInfoOrderFood(username);
    }
}
