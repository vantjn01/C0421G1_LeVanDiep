package com.example.demo.service;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
    @Autowired
    private IFeedbackRepository iFeedbackRepository;
// Diep tao feedback
    @Override
    public void createFeedback(Feedback feedback) {
        this.iFeedbackRepository.createFeedback(feedback.getFeedbackId(), feedback.isDeleteFlag(), feedback.getFeedbackContent(), feedback.getFeedbackDate(), feedback.getFeedbackEmail(), feedback.getFeedbackImage(), feedback.getFeedbackPeople());
    }
}
