package com.example.webfastfood.entity.oders;




import com.example.webfastfood.entity.food.Food;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id")
    private Long orderStatusId;
    private String orderStatusName;

    @OneToMany(mappedBy = "orderStatus")
    @JsonBackReference(value = "orders-ordersStatus")
    private List<Orders>ordersList;


}
