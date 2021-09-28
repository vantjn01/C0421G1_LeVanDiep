package com.example.model.entity.transaction;



import javax.persistence.*;



@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private String transactionCode;

    @Column(columnDefinition = "DATE")
    private String dayTrading;
    private String rentTrading;
    private Double unitPrice;
    private Double area;

//    @Column(columnDefinition = "LONGTEXT ")
//    private String img;



    @ManyToOne
    @JoinColumn(name = "customer_name", referencedColumnName = "customerId")
    private Customer customer;

    public Transaction() {
    }

    public Transaction(Long transactionId, String transactionCode, String dayTrading, String rentTrading, Double unitPrice, Double area, Customer customer) {
        this.transactionId = transactionId;
        this.transactionCode = transactionCode;
        this.dayTrading = dayTrading;
        this.rentTrading = rentTrading;
        this.unitPrice = unitPrice;
        this.area = area;
        this.customer = customer;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getDayTrading() {
        return dayTrading;
    }

    public void setDayTrading(String dayTrading) {
        this.dayTrading = dayTrading;
    }

    public String getRentTrading() {
        return rentTrading;
    }

    public void setRentTrading(String rentTrading) {
        this.rentTrading = rentTrading;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}