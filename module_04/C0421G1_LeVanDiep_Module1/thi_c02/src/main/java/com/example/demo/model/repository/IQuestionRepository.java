package com.example.demo.model.repository;

import com.example.demo.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IQuestionRepository extends JpaRepository<Question, Long> {


    Optional<Question> findById(Long id);

//    Page<Question> findAllByTitleContaining(Pageable pageable, String type);
//    Page<Question> findAllByQuestionType_QuestionTypeName(Pageable pageable, String name);
    @Query (value ="select * from question q join questiontype qt on " +
            "q.question_type_id = qt.question_type_id where q.title like :title " +
            "and qt.question_type_name like :questionType", nativeQuery = true)
    Page<Question> findAllByTitleContainingAndQuestionType_QuestionTypeName(
            Pageable pageable,  @Param("title") String title,@Param("questionType") String questionType );

    @Query(value = "select * from question ", nativeQuery = true)
    List<Question> findAll();

}


