package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "status_food")
public class StatusFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_food_id")
    private Long statusFoodId;
    @Column(name = "status_food_name")
    private String statusFoodName;

    @OneToMany(mappedBy = "statusFood")
    @JsonBackReference(value = "food-status-food")
    List<Food> foodStatusList;
}
