package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.OrderFood;
import com.example.demo.repositories.OrderFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderFoodService {
    @Autowired
    OrderFoodRepository orderFoodRepository;

    @Override
    public void saveOrderFoodDto(CartDto cartDto) {
        orderFoodRepository.saveOrderFoodDto(cartDto.getFoodId(),cartDto.getQuantity(),cartDto.getOrdersId());
    }

    @Override
    public List<OrderFood> getInfoOrderFood(String username) {
        return orderFoodRepository.getInfoOrderFood(username);
    }
}
