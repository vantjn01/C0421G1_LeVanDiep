package com.example.demo.model.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberCar;
    private String typeCar;
    private String nameCar;
    private String phone;
    private String email;
    private String fromHour;
    private String toHour;
    @ManyToOne(targetEntity = FromCar.class)
    @JsonManagedReference
    @JoinColumn(name = "fromCar_id", referencedColumnName = "id")
    private FromCar fromCar;
    @ManyToOne(targetEntity = ToCar.class)
    @JsonManagedReference
    @JoinColumn(name = "toCar_id", referencedColumnName = "id")
    private ToCar toCar;

    public Car() {
    }

    public Car(Integer id, Integer numberCar, String typeCar, String nameCar, String phone, String email, String fromHour, String toHour, FromCar fromCar, ToCar toCar) {
        this.id = id;
        this.numberCar = numberCar;
        this.typeCar = typeCar;
        this.nameCar = nameCar;
        this.phone = phone;
        this.email = email;
        this.fromHour = fromHour;
        this.toHour = toHour;
        this.fromCar = fromCar;
        this.toCar = toCar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(Integer numberCar) {
        this.numberCar = numberCar;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public FromCar getFromCar() {
        return fromCar;
    }

    public void setFromCar(FromCar fromCar) {
        this.fromCar = fromCar;
    }

    public ToCar getToCar() {
        return toCar;
    }

    public void setToCar(ToCar toCar) {
        this.toCar = toCar;
    }
}
