package com.example.demo.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "toCar")
public class ToCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameToCar;

    @JsonBackReference
    @OneToMany(mappedBy = "toCar", cascade = CascadeType.ALL)
    private Set<Car> carSet;
    public ToCar() {
    }

    public ToCar(Integer id, String nameToCar) {
        this.id = id;
        this.nameToCar = nameToCar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameToCar() {
        return nameToCar;
    }

    public void setNameToCar(String nameToCar) {
        this.nameToCar = nameToCar;
    }
}
