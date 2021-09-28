package com.example.dto;

import com.example.model.entity.transaction.Customer;

import com.example.model.entity.transaction.Transaction;
import com.example.model.service.ITransactionService;
import com.example.model.service.impl.TransactionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;



@Component

public class TransactionDto implements Validator {

    @Autowired
    private ITransactionService transactionServices;

    private Long transactionId;

    @NotBlank(message = "Mã giao dịch không dược để trống")
    @Pattern(regexp = "^MGD-\\d{4}$", message = "Mã giao dịch phải đúng định dạng (MGD-xxxx)")
    private String transactionCode;
    @NotBlank(message = "Vui lòng chọn ngày giao dịch")


    private String dayTrading;

    @NotNull(message = "Vui lòng chọn loại bất động sản")
    private String rentTrading;

    @NotNull(message = "Đơn giá không được để trống")
    @Min(value = 500000, message = "Đơn giá phải là số và phải lớn hơn 500.000 (VND).")
    private Double unitPrice;


    @NotNull(message = "Diện tích không được để trống")
    @Min(value = 20, message = "Diện tích phải là số và lớn hơn 20 (m2).")

    private Double area;


//    private String img;

    private Customer customer;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        TransactionDto transactionDto = (TransactionDto) target;

//        Optional<Transaction> transaction = transactionServices.findByTransactionCode(transactionDto.getTransactionCode());
//        if(transaction.isPresent()){
//            errors.rejectValue("transactionCode","","Mã khách hàng đã tồn tại");
//        }
        Date dateNow = new java.sql.Date(System.currentTimeMillis());

        Date dayTrading = null;
        try {
            dayTrading = new SimpleDateFormat("yyyy-MM-dd").parse(transactionDto.getDayTrading());
            if (dayTrading.before(dateNow)) {
                errors.rejectValue("dayTrading", "",
                        "Ngày giao dịch phải lớn hơn ngày hiện tại");
            }
        } catch (ParseException e) {
            errors.rejectValue("dayTrading", "",
                    "");
            e.printStackTrace();
        }


    }

    public TransactionDto(ITransactionService transactionServices, Long transactionId, @NotBlank(message = "Mã giao dịch không dược để trống") @Pattern(regexp = "^MGD-\\d{4}$", message = "Mã giao dịch phải đúng định dạng (MGD-xxxx)") String transactionCode, @NotBlank(message = "Vui lòng chọn ngày giao dịch") String dayTrading, @NotNull(message = "Vui lòng chọn loại bất động sản") String rentTrading, @NotNull(message = "Đơn giá không được để trống") @Min(value = 500000, message = "Đơn giá phải là số và phải lớn hơn 500.000 (VND).") Double unitPrice, @NotNull(message = "Diện tích không được để trống") @Min(value = 20, message = "Diện tích phải là số và lớn hơn 20 (m2).") Double area, Customer customer) {
        this.transactionServices = transactionServices;
        this.transactionId = transactionId;
        this.transactionCode = transactionCode;
        this.dayTrading = dayTrading;
        this.rentTrading = rentTrading;
        this.unitPrice = unitPrice;
        this.area = area;
        this.customer = customer;
    }

    public TransactionDto() {
    }

    public ITransactionService getTransactionServices() {
        return transactionServices;
    }

    public void setTransactionServices(ITransactionService transactionServices) {
        this.transactionServices = transactionServices;
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
