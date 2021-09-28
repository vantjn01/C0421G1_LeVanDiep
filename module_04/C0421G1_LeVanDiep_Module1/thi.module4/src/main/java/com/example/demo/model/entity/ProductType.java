package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productType")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productTypeId;
    @OneToMany(mappedBy = "productType")
    private List<Product> product;
    private String productTypeName;

    public ProductType() {
    }

    public ProductType(Long productTypeId, List<Product> product, String productTypeName) {
        this.productTypeId = productTypeId;
        this.product = product;
        this.productTypeName = productTypeName;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
