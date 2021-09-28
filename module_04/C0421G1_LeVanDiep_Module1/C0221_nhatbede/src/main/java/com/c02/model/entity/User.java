package com.c02.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Question> question;

    public User() {
    }

    public User(Integer userId, String userName, Set<Question> question) {
        this.userId = userId;
        this.userName = userName;
        this.question = question;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Question> getQuestion() {
        return question;
    }

    public void setQuestion(Set<Question> question) {
        this.question = question;
    }
}
