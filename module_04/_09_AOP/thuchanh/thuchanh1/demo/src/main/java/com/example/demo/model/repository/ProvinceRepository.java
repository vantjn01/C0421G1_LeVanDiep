package com.example.demo.model.repository;

import com.example.demo.model.entity.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
