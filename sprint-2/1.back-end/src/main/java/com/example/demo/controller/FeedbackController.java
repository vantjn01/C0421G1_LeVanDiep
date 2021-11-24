package com.example.demo.controller;


import com.example.demo.dto.FeedbackDto;
import com.example.demo.entity.Feedback;
import com.example.demo.service.FeedbackServiceImpl;
import com.example.demo.service.IFeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/feedback")
public class FeedbackController {
@Autowired
    private IFeedbackService iFeedbackService;
    @PostMapping("/add")
    public ResponseEntity<Integer> addFeedback(@RequestBody @Validated FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedbackDto, feedback);
        iFeedbackService.createFeedback(feedback);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

}

