package com.example.demo.dto;

import com.example.demo.model.entity.QuestionType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class QuestionDto {

    private Long id;
    @NotEmpty
    @Size(min = 5, max = 10)
    private String title;
    @NotEmpty
    @Size(min = 5, max = 100)
    private String question;

    private String answer;
    private QuestionType questionType;
    private String date_create;
    private int status;

    public QuestionDto() {
    }

    public QuestionDto(Long id, @NotEmpty @Size(min = 5, max = 10) String title, String question, @NotEmpty @Size(min = 5, max = 100) String answer, QuestionType questionType, String date_create, int status) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.date_create = date_create;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
