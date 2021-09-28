package com.example.demo.model.repository.employee;

import com.example.demo.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByEmployeeId(Long id);

    @Query(value = "select * from employee c join `position` p on c.position_id = p.position_id where c.employee_name like :name and p.position_name like :position", nativeQuery = true)
    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, @Param("name") String name, @Param("position") String position);

    @Query(value = "select * from employee ", nativeQuery = true)
    List<Employee> findAll();
}
