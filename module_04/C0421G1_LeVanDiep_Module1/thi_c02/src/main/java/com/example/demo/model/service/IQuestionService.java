package com.example.demo.model.service;

import com.example.demo.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {
    Optional<Question> findById(Long id);

    Page<Question>  findAllByTitleContainingAndQuestionType_QuestionTypeName(
            Pageable pageable,String title, String questionType);

    void save(Question question);

//    Page<Question> findAllByTitleContaining(Pageable pageable, String type);
//    Page<Question> findAllByQuestionType_QuestionTypeName(Pageable pageable, String name);


    Page<Question> findAll(Pageable pageable);

//    Page<Customer> findAllCustomerUserService(Pageable pageable,String name);

    void delete(Long id);
}
