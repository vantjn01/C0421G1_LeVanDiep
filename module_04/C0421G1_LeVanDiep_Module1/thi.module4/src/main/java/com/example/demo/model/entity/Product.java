package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String price;
    private String status;
    @OneToMany(mappedBy = "product")
    private List<Order> order;
    @JsonManagedReference
    @ManyToOne(targetEntity = ProductType.class)
    @JoinColumn(name = "prodcut_type_id", referencedColumnName = "productTypeId")
    private ProductType productType;

    public Product() {
    }

    public Product(Long productId, String productName, String price, String status, List<Order> order, ProductType productType) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.order = order;
        this.productType = productType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
// + ma_sp: khóa chính với kiểu dữ liệu là kiểu số tự tăng
// 		+ ten_sp: Tên sản phẩm với kiểu dữ liệu là kiểu chuỗi
// 		+ gia_sp: Giá bán bắt đầu với kiểu dữ liệu là kiểu số
//  		+ tinh_trang_sp: Tình trạng đấu giá của sản phẩm với kiểu dữ liệu là kiểu chuỗi
//  		+ ma_loai_sp: là khóa ngoại được tham chiếu từ table loại sản phẩm
