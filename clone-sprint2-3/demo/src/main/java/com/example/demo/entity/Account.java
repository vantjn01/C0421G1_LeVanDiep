package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountRoleId;
    private String username;
    private String password;

    private String userTime;
    private int status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet = new HashSet<>();

    @OneToOne(mappedBy = "account")
    @JsonBackReference(value = "account-customer")
    private Customer customer;

//    @OneToOne(mappedBy = "account")
//    @JsonBackReference(value = "account-employee")
//    private Employee employee;

    @OneToMany(mappedBy = "account")
    @JsonBackReference("orders-account")
    private List<Orders> accountOfOrderList;

}
