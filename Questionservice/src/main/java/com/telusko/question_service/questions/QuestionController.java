package com.telusko.question_service.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.question_service.questionentity.Question;
import com.telusko.question_service.questionentity.QuestionWrapper;
import com.telusko.question_service.questionentity.Response;
import com.telusko.question_service.questionservice.QuestionService;



@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allquestions")
	public ResponseEntity<List<Question>> getAllquestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
	    return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("/addquestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.save(question);
	}

	
	// generate
	// getQuestions(questionid)
	// getScore
	
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(
			@RequestParam String categoryName, 
			@RequestParam Integer numQuestions){
		return questionService.getQuestionsForQuiz(categoryName, numQuestions);
	}
	
	@PostMapping("/getQuesitions")
	public ResponseEntity<List<QuestionWrapper>> getQuesutionsFromId(
			@RequestBody List<Integer> questionIds){
		return questionService.getQuestionsFromId(questionIds);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer>  getScore(
			@RequestBody List<Response> responses)
	{
		return questionService.getScore(responses);
	}
}
