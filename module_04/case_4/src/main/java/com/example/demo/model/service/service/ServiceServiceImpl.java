package com.example.demo.model.service.service;

import com.example.demo.model.entity.Services;
import com.example.demo.model.repository.service.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceServiceImpl implements IServiceService{
    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public void save(Services services) {
        this.iServiceRepository.save(services);

    }

    @Override
    public Services findByServiceId(Long id) {
        return this.iServiceRepository.findByServiceId(id);
    }

    @Override
    public Page<Services> findAllByServiceNameContaining(Pageable pageable, String name) {
        return this.iServiceRepository.findAllByServiceNameContaining(pageable, "%"+name+"%");
    }

    @Override
    public List<Services> findAll() {
        return this.iServiceRepository.findAll();
    }
}
