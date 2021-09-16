package com.example.model.service;

import com.example.model.entity.Customer;
import com.example.model.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
//    List<Customer> findAll();
//
//    Customer findById(Long id);
//
//    void save(Customer customer);
//
//    void remove(Long id);
}
