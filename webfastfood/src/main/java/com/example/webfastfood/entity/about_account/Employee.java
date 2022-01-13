package com.example.webfastfood.entity.about_account;

import com.example.webfastfood.entity.customer.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    private String salary;
    private String idCard;
    private String name;
    private String employeeCode;
    private String birthDate;
    private String address;
    private String email;
    private String image;
    private String phone;
    private Long flag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    @JsonBackReference(value = "account-employee")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
    private Gender gender;

}
