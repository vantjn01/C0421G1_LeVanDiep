package com.example.demo.model.repository;

import com.example.demo.model.entity.QuestionType;
import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IQuestionType extends JpaRepository<QuestionType, Long> {
    List<QuestionType> findAll();
}
