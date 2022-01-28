package com.example.webfastfood.entity.oders;




import com.example.webfastfood.entity.customer.Customer;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;
    private Integer quantityFood;

    @ManyToOne
    @JoinColumn(name = "orders_id",referencedColumnName = "ordersId")
    private Orders orders;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fad_id", referencedColumnName = "fadId")
    private Food food;
}
