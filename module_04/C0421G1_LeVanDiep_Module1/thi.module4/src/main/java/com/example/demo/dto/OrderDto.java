package com.example.demo.dto;

import com.example.demo.model.entity.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.validation.Errors;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDto {
    private Long id;
    @NotBlank(message = "Vui lòng chọn ngày mua")
    private String date_buy;
    @Min(value = 0, message = "số lượng phải lớn hơn 0.")
    private String quantity;
    private Product product;
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//    @Override
//    public void validate(Object target, Errors errors) {
//        OrderDto orderDto = (OrderDto) target;
//
////        Optional<Transaction> transaction = transactionServices.findByTransactionCode(transactionDto.getTransactionCode());
////        if(transaction.isPresent()){
////            errors.rejectValue("transactionCode","","Mã khách hàng đã tồn tại");
////        }
//        Date dateNow = new java.sql.Date(System.currentTimeMillis());
//
//        Date date_buy = null;
//        try {
//            date_buy = new SimpleDateFormat("yyyy-MM-dd").parse(orderDto.getDate_buy());
//            if (date_buy.before(dateNow)) {
//                errors.rejectValue("date_buy", "",
//                        "Ngày mua phải lớn hơn ngày hiện tại");
//            }
//        } catch (ParseException e) {
//            errors.rejectValue("date_buy", "",
//                    "");
//            e.printStackTrace();
//        }
//
//
//    }

    public OrderDto(Long id, @NotBlank(message = "Vui lòng chọn ngày mua") String date_buy, @Min(value = 0, message = "số lượng phải lớn hơn 0.") String quantity, Product product) {
        this.id = id;
        this.date_buy = date_buy;
        this.quantity = quantity;
        this.product = product;
    }

    public OrderDto() {
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
