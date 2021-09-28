package com.example.demo.model.repository.employee;

import com.example.demo.model.entity.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<EducationDegree, Integer> {
}
