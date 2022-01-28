package com.example.webfastfood.dto;

import com.example.webfastfood.entity.food.Category;
import com.example.webfastfood.entity.oders.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    private Integer fadId;

    private String fadName;

    private String fadImage;

    private boolean deleteFlag;

    private String fadCode;

    private double fadPrice;

    private Integer fadWaitTime;

    private Category category;

    Set<OrderDetail> orderDetails;


}
