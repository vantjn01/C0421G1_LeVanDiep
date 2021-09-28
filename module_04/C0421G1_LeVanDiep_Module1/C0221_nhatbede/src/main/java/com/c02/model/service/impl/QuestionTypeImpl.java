package com.c02.model.service.impl;

import com.c02.model.entity.QuestionType;
import com.c02.model.repository.QuestionTypeRepository;
import com.c02.model.service.QuestionService;
import com.c02.model.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionTypeImpl implements QuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> finAll() {
        return questionTypeRepository.findAll();
    }
}
