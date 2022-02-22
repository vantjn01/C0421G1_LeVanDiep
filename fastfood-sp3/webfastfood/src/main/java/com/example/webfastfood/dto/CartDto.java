package com.example.webfastfood.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDto {
    private FoodDto food;
    private Long foodId;
    private Integer quantity;
    private Long ordersId;

}
