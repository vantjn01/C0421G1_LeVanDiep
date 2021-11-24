package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;
    private String feedbackDate;
    private String feedbackPeople;
    private String feedbackEmail;
    private String feedbackContent;
    private String feedbackImage;
    private boolean deleteFlag;
}
