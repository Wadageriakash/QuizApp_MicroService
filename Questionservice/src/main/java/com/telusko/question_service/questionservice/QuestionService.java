package com.telusko.question_service.questionservice;

import java.util.List;


import com.telusko.question_service.questionentity.Response;
import org.springframework.http.ResponseEntity;

import com.telusko.question_service.questionentity.Question;
import com.telusko.question_service.questionentity.QuestionWrapper;


public interface QuestionService {

	ResponseEntity<List<Question>> getAllQuestions();

	ResponseEntity<List<Question>> getQuestionByCategory(String category);

	ResponseEntity<String> save(Question question);

	ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions);

	ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds);

	ResponseEntity<Integer> getScore(List<Response> responses);
}
