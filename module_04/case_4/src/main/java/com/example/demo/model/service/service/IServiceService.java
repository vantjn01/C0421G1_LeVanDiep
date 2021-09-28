package com.example.demo.model.service.service;

import com.example.demo.model.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    void save(Services services);

    Services findByServiceId(Long id);

    Page<Services> findAllByServiceNameContaining(Pageable pageable, String name);

    List<Services> findAll();
}
