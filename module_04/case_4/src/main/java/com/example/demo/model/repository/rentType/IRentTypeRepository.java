package com.example.demo.model.repository.rentType;

import com.example.demo.model.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentTypeRepository extends JpaRepository<RentType, Long> {
    List<RentType> findAll();

}
