package com.example.demo.model.repository.customerType;

import com.example.demo.model.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
    List<CustomerType> findAll();

}
