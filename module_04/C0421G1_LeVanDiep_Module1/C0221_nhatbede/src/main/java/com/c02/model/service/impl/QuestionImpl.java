package com.c02.model.service.impl;

import com.c02.model.entity.Question;
import com.c02.model.repository.QuestionRepository;
import com.c02.model.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionImpl  implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public Page<Question> findAll(Pageable pageable, String name, String questionType) {
        return questionRepository.findAll(pageable,"%"+name+"%","%"+questionType+"%");
    }

    @Override
    public Question findById(Integer integer) {
        return questionRepository.findById(integer).get();
    }

    @Override
    public void delete(Integer integer) {
       questionRepository.deleteById(integer);
    }

    @Override
    public void save(Question question) {
          questionRepository.save(question);
    }
}
