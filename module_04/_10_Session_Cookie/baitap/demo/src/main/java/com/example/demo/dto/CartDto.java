package com.example.demo.dto;

import com.example.demo.model.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
private Map<ProductDto,Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    //    public Map<ProductDto,Integer> getProductMap() {
//        return productMap;
//    }
//    public void setProductMap(Map<ProductDto,Integer> productMap)





    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
           Integer currentValue = productMap.get(productDto);
           productMap.put(productDto, currentValue+ 1);
        } else {
            productMap.put(productDto,1);

        }
    }



//    public void removeProduct(Product product) {
//        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
//        products.remove(itemEntry.getKey());
//    }
//
//    public Integer countProductQuantity(){
//        Integer productQuantity = 0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            productQuantity += entry.getValue();
//        }
//        return productQuantity;
//    }
//
//    public Integer countItemQuantity(){
//        return products.size();
//    }
//
//    public Float countTotalPayment(){
//        float payment = 0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            payment += entry.getKey().getPrice() * (float) entry.getValue();
//        }
//        return payment;
//    }
}

