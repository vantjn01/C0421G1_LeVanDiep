package com.example.demo.repository;

import com.example.demo.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
    //DiepLV do create feedback
    @Modifying
    @Query(value = "insert into `feedback` (feedback_id,delete_flag,feedback_content,feedback_date,feedback_email, " +
            " feedback_image, feedback_people) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void createFeedback(Integer feedback_id, boolean delete_flag, String feedback_content, String feedback_date, String feedback_email, String feedback_image,
                     String feedback_people);
}
