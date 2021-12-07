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
@Table(name = "type_food")
public class TypeFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_food_id")
    private Long typeFoodId;
    @Column(name = "type_food_name")
    private String typeFoodName;

    @OneToMany(mappedBy = "typeFood")
    @JsonBackReference(value = "food-typeFood")
    private List<Food> foodList;
}
