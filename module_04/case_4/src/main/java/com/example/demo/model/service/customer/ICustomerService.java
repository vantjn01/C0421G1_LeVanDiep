package com.example.demo.model.service.customer;

import com.example.demo.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Customer findByCustomerId(Long id);

    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name);

    void save(Customer customer);

    List<Customer> findAll();

    Page<Customer> findAllCustomerUserService(Pageable pageable,String name);

    void delete(Customer customer);
}
