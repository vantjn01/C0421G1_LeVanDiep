package com.c02.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  questionTypeId;
    private String questionTypeName;
    @OneToMany(mappedBy = "questionType",cascade = CascadeType.ALL)
    private List<Question> questions;

    public QuestionType() {
    }

    public QuestionType(Integer questionTypeId, String questionTypeName, List<Question> questions) {
        this.questionTypeId = questionTypeId;
        this.questionTypeName = questionTypeName;
        this.questions = questions;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
