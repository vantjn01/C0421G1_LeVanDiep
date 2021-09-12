package com.example.demo.model.service;

import com.example.demo.model.entity.Smartphone;

import java.util.Optional;

public interface IPhoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);


    void remove(Long id);
}
