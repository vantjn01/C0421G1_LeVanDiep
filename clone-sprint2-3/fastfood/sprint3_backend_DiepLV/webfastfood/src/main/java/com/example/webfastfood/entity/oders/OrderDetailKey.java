//package com.example.webfastfood.entity.oders;
//
//import com.example.webfastfood.entity.food.Food;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Embeddable
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class OrderDetailKey implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long orderFoodId;
//    private Integer quantityFood;
//
//    @ManyToOne
//    @JoinColumn(name = "orders_id",referencedColumnName = "ordersId")
//    private Orders orders;
//
//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "food_id", referencedColumnName = "foodId")
//    private Food food;
//}
