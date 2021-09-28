package com.example.demo.model.service.employee;

import com.example.demo.model.entity.Employee;
import com.example.demo.model.entity.Services;
import com.example.demo.model.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findByEmployeeId(Long id) {
        return this.iEmployeeRepository.findByEmployeeId(id);
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name, String position) {
        return this.iEmployeeRepository.findAllByEmployeeNameContaining(pageable, "%"+name+"%","%" + position +"%");
    }

    @Override
    public List<Employee> findAll() {
        return this.iEmployeeRepository.findAll();
    }

    @Override
    public void delete(Employee employee) {
        this.iEmployeeRepository.delete(employee);
    }
}
