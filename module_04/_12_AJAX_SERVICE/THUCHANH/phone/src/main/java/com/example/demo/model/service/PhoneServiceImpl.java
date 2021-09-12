package com.example.demo.model.service;

import com.example.demo.model.entity.Smartphone;
import com.example.demo.model.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PhoneServiceImpl implements IPhoneService{
    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return this.phoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return this.phoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return this.phoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        this.phoneRepository.deleteById(id);
    }


}
