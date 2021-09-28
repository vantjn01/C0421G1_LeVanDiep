package com.c02.dto;

import com.c02.model.entity.QuestionType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class QuestionDto {
    private Integer questionId;
    @NotEmpty(message = "Tieu đề từ 5 đến 1000 kí tự")
    private String title;
    @NotEmpty(message = "các trường không được trống")
    private String question;
    @NotEmpty(message = "các trường không được trống")
    private String answer;
    @NotEmpty(message = "các trường không được trống")
    private String dateCreate;
//    @NotEmpty(message = "các trường không được trống")
    private QuestionType questionType;

    public QuestionDto() {
    }

    public QuestionDto(Integer questionId, String title, String question, String answer, String dateCreate, QuestionType questionType) {
        this.questionId = questionId;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.questionType = questionType;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
