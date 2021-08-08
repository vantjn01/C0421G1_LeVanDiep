package model.service;

import model.bean.Student;

import java.util.List;

public interface StudentService {
      List<Student> findAll();

      void save(Student student);

      Student findById(int id);

      void remove(int id);

      //validationName..
}
