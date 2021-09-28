package com.c02.model.repository;

import com.c02.model.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeRepository extends JpaRepository<QuestionType,Integer> {
}
