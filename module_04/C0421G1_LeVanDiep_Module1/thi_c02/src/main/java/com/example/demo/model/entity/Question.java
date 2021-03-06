package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String question;
    private String answer;
    @JsonManagedReference
    @ManyToOne(targetEntity = QuestionType.class)
    @JoinColumn(name = "question_type_id", referencedColumnName = "questionTypeId")
    private QuestionType questionType;
    private String date_create;
    private int status;

    public Question() {
    }

    public Question(Long id, String title,String question, String answer, QuestionType questionType, String date_create, int status) {
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
//  + id: kh??a ch??nh v???i ki???u d??? li???u l?? ki???u s??? t??? t??ng
//          + title: ti??u ????? c??u h???i v???i ki???u d??? li???u v??n b???n
//          + question: N???i dung c???a c??u h???i v???i ki???u d??? li???u v??n b???n
//          + answer: N???i dung ph???n h???i c???a c??u h???i v???i ki???u d??? li???u v??n b???n
//          + id_question_type: l?? kh??a ngo???i tham chi???u t??? table [QuestionType]
//          + date_create: Ng??y t???o c??u h???i
//          + status: T??nh tr???ng c??u h???i l?? ???Ch??? ph???n h???i??? ho???c ??????? ph???n h???i???

