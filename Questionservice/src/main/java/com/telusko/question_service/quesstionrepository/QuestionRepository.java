package com.telusko.question_service.quesstionrepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.question_service.questionentity.Question;



@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    // Corrected Native Query with Positional Parameters
    @Query(value = "SELECT q.id FROM QUESTION Q WHERE Q.CATEGORY = ?1 ORDER BY RANDOM() LIMIT ?2", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, Integer num);
}
