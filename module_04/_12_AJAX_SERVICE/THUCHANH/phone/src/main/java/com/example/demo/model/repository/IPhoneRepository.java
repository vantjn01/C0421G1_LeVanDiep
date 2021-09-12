package com.example.demo.model.repository;

import com.example.demo.model.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepository extends JpaRepository<Smartphone, Long> {
}
