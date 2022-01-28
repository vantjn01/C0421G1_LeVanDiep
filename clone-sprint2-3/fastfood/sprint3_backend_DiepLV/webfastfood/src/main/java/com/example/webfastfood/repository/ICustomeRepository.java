package com.example.webfastfood.repository;

import com.example.webfastfood.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICustomeRepository extends JpaRepository<Customer, Integer> {
    @Query(value = " select customer_id,customer_address,customer_birthday,customer_email,customer_gender,customer_name,customer_phone,account_id\n" +
            " FROM customer\n" +
            "JOIN account on customer.account_id = account.account_id\n" +
            " where account.account_username = ?1 ", nativeQuery = true)
    Customer getInfoCustomer(String username);
}
