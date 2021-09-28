package com.example.demo.model.service;

import com.example.demo.model.entity.Question;
import com.example.demo.model.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService{
    @Autowired
    private IQuestionRepository iQuestionRepository;
    @Override
    public Optional<Question> findById(Long id) {
        return iQuestionRepository.findById(id);
    }


    @Override
    public Page<Question>  findAllByTitleContainingAndQuestionType_QuestionTypeName(
            Pageable pageable,String title, String questionType) {

        return iQuestionRepository.findAllByTitleContainingAndQuestionType_QuestionTypeName(
                pageable ,"%"+title+"%","%" + questionType +"%");
    }

    @Override
    public void save(Question question) {
        iQuestionRepository.save(question);

    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return iQuestionRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        iQuestionRepository.deleteById(id);
    }


}
