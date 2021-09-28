package com.c02.model.service;

import com.c02.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionService {
    @Query(value="select * from question q join question_type qt" +
            " on q.question_type_id=qt.question_type_id where q.title like :name and qt.question_type_name like :questionType",nativeQuery=true)
    Page<Question> findAll(Pageable pageable, @Param("name") String name, @Param("questionType") String questionType);

    Question findById (Integer integer);
    void delete(Integer integer);
    void save(Question question);
}
