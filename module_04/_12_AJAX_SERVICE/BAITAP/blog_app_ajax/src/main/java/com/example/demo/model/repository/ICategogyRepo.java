package com.example.demo.model.repository;

import com.example.demo.model.bean.Categogy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategogyRepo extends JpaRepository<Categogy, Integer> {
}
