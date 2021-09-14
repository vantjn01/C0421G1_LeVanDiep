package com.example.demo.controller;

import com.example.demo.model.entity.Smartphone;
import com.example.demo.model.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class PhoneController {
    @Autowired
    private IPhoneService phoneService;
    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(phoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("smartphones", phoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = phoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       phoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    //Cap nhat object
    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> editById(@PathVariable Long id, @RequestBody Smartphone smartphone) {
        Smartphone smartphoneUpdate = phoneService.findById(id).get();

        if (smartphoneUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        smartphoneUpdate.setModel(smartphone.getModel());
//        smartphoneUpdate.setPrice(smartphone.getPrice());
//        smartphoneUpdate.setProducer(smartphone.getProducer());

        this.phoneService.save(smartphoneUpdate);
        return new ResponseEntity<>(smartphoneUpdate, HttpStatus.OK);
    }
}
