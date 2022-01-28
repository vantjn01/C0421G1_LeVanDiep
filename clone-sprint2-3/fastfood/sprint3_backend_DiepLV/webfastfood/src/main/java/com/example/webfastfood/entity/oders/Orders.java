package com.example.webfastfood.entity.oders;




import com.example.webfastfood.entity.about_account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersId;
    private String dateOrders;

    @OneToMany(mappedBy = "orders")
    @JsonBackReference("orders-food-orders")
    private List<OrderDetail> ordersList;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
