package com.example.demo.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fromCar")
public class FromCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameFromCar;
    @JsonBackReference
    @OneToMany(mappedBy = "fromCar", cascade = CascadeType.ALL)
    private Set<Car> carSet;

    public FromCar() {
    }

    public FromCar(Integer id, String nameFromCar) {
        this.id = id;
        this.nameFromCar = nameFromCar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFromCar() {
        return nameFromCar;
    }

    public void setNameFromCar(String nameFromCar) {
        this.nameFromCar = nameFromCar;
    }
}
