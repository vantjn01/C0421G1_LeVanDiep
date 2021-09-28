package com.c02.model.entity;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String title;
    private String question;
    private String answer;
    private String dateCreate;
    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "questionType_id",referencedColumnName = "questionTypeId")
    private QuestionType questionType;

    public Question() {
    }

    public Question(Integer questionId, String title, String question, String answer, String dateCreate, User user, QuestionType questionType) {
        this.questionId = questionId;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
