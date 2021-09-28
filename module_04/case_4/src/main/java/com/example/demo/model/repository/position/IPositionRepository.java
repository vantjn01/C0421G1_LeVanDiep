package com.example.demo.model.repository.position;

import com.example.demo.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPositionRepository extends JpaRepository<Position,Long> {
    List<Position> findAll();

}
