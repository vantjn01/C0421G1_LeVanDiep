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
//  + id: khóa chính với kiểu dữ liệu là kiểu số tự tăng
//          + title: tiêu đề câu hỏi với kiểu dữ liệu văn bản
//          + question: Nội dung của câu hỏi với kiểu dữ liệu văn bản
//          + answer: Nội dung phản hồi của câu hỏi với kiểu dữ liệu văn bản
//          + id_question_type: là khóa ngoại tham chiếu từ table [QuestionType]
//          + date_create: Ngày tạo câu hỏi
//          + status: Tình trạng câu hỏi là “Chờ phản hồi” hoặc “Đã phản hồi”

