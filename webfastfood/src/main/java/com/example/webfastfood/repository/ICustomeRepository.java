package com.example.webfastfood.repository;

import com.example.webfastfood.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICustomeRepository extends JpaRepository<Customer, Long> {
    @Query(value = " select * " +
            " from customer " +
            " left join gender on customer.gender_id = gender.gender_id " +
            " left join account on customer.account_id = account.account_id " +
            " where account.`username`= ?1 ", nativeQuery = true)
    Customer getInfoCustomer(String username);
}
