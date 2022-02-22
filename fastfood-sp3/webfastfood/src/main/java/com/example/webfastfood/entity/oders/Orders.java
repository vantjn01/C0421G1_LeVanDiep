package com.example.webfastfood.entity.oders;




import com.example.webfastfood.entity.about_account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long ordersId;
    private String dateOrders;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "orders")
    @JsonBackReference("orders-food-orders")
    private List<OrderFood>orderFoodOfOrdersList;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
