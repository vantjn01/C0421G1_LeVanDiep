package com.example.demo.model.repository;

import com.example.demo.model.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value= "{call Insert_Customer(:firstName, :lastName)}", nativeQuery=true)
    void insertWithStoredProcedure(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
