package com.example.demo.model.repository.educationDegree;

import com.example.demo.model.entity.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Long> {
    List<EducationDegree> findAll();

}
