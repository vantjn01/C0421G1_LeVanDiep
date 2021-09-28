package com.example.model.entity.transaction;



import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String customerCode;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;

    public Customer(Long customerId, String customerName, String customerCode, String phone, String email, List<Transaction> transactions) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerCode = customerCode;
        this.phone = phone;
        this.email = email;
        this.transactions = transactions;
    }

    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}