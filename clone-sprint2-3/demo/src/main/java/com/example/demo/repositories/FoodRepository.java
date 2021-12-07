package com.example.demo.repositories;

import com.example.demo.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query(value = "select * " +
            "from food " +
            "left join  status_food on food.status_food_id = status_food.status_food_id " +
            "left join type_food on food.type_food_id = type_food.type_food_id " +
            "where food.flag = 0 and food.food_name like %?1% ", nativeQuery = true)
    List<Food> searchListFood(String keySearch);

    @Query(value = "select * " +
            "from food " +
            "left join  status_food on food.status_food_id = status_food.status_food_id " +
            "left join type_food on food.type_food_id = type_food.type_food_id " +
            "where food.flag = 0 " +
            "order by date_create desc ", nativeQuery = true)
    Page<Food> getListFood(Pageable pageable);

    @Query(value = "select * " +
            "from food " +
            "left join  status_food on food.status_food_id = status_food.status_food_id " +
            "left join type_food on food.type_food_id = type_food.type_food_id " +
            "where food.flag = 0 and food.food_id = ?1 ", nativeQuery = true)
    Food getFoodById(Long foodId);
}
