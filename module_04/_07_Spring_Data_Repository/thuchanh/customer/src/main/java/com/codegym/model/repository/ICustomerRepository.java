package com.codegym.model.repository;

import com.codegym.model.bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);


}
