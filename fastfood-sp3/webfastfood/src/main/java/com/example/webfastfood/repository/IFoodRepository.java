package com.example.webfastfood.repository;

import com.example.webfastfood.entity.food.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IFoodRepository extends JpaRepository<Food, Long> {

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
