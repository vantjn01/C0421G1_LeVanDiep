package com.example.demo.model.repository;

import com.example.demo.model.bean.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICarRepository extends JpaRepository<Car, Integer> {
    Car findByCarId(Integer id);

    @Query(value = "select * from car c join `fromCar` p on c.fromCar_id = p.fromCar_id where c.car_name like :name and p.name_fromCar like :fromCar", nativeQuery = true)
    Page<Car> findAllByCarNameContaining(Pageable pageable, @Param("nameCar") String nameCar, @Param("fromCar") String fromCar);

    @Query(value = "select * from car ", nativeQuery = true)
    List<Car> findAll();
}
