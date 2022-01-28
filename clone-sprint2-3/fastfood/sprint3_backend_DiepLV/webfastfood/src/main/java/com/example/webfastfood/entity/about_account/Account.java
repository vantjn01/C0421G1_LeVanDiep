package com.example.webfastfood.entity.about_account;




import com.example.webfastfood.entity.customer.Customer;
import com.example.webfastfood.entity.oders.Orders;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public  class  Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String accountUsername;
    private String accountPassword;
    private String email;
    private boolean deleteFlag;
    private boolean activeFlag;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @JsonBackReference(value = "customer_account")
    @OneToOne(mappedBy = "account")
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Orders> ordersList;

}
