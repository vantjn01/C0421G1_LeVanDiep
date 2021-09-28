package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date_buy;
    private String quantity;

    @JsonManagedReference
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "prodcut_id", referencedColumnName = "productId")
    private Product product;

    public Order() {
    }

    public Order(Long id, String date_buy, String quantity, Product product) {
        this.id = id;
        this.date_buy = date_buy;
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_buy() {
        return date_buy;
    }

    public void setDate_buy(String date_buy) {
        this.date_buy = date_buy;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
// + ma_don_hang: khóa chính với kiểu dữ liệu là kiểu số tự tang
//+  ngay_mua: Ngày đặt hàng, kiểu datetime
//+ so_luong: số lượng sản phẩm đặt mua, kiểu số
//+ ma_sp: là khóa ngoại tham chiếu đến table sản phẩm
