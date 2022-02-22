package com.example.webfastfood.entity.food;

import com.example.webfastfood.entity.oders.OrderFood;
import com.example.webfastfood.entity.transaction.CommentFood;
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
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;
    @Column(name = "food_name")
    private String foodName;
    @Column(name = "food_price")
    private Integer foodPrice;
    @Column(name = "description_food",length = 1000)
    private String description_food;
    @Column(name = "flag")
    private Integer flag;
    @Column(name = "image")
    private String image;
    @Column(name = "address")
    private String address;
    @Column(name = "date_create")
    private String dateCreate;

    @ManyToOne
    @JoinColumn(name = "type_food_id")
    private TypeFood typeFood;

    @ManyToOne
    @JoinColumn(name = "status_food_id")
    private StatusFood statusFood;

    @OneToMany(mappedBy = "food")
    @JsonBackReference(value = "orders-food-food")
    private List<OrderFood> orderFoodOfFoodList;

    @OneToMany(mappedBy = "foodContent")
    @JsonBackReference(value = "comment-food-food")
    private List<CommentFood> commentFoods;
}
