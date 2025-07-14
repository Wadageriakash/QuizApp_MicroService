package com.telusko.question_service.questionserviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.telusko.question_service.questionentity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.question_service.quesstionrepository.QuestionRepository;
import com.telusko.question_service.questionentity.Question;
import com.telusko.question_service.questionentity.QuestionWrapper;
import com.telusko.question_service.questionservice.QuestionService;



@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.BAD_REQUEST);
	}

	
	@Override
	public ResponseEntity<String> save(Question question) {
		questionRepository.save(question);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
		List<Integer> questions = questionRepository.findRandomQuestionsByCategory(categoryName, numQuestions);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
	
	
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds){
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		
		for(Integer id : questionIds) {
			questions.add(questionRepository.findById(id).get());
		}
		
		for(Question question : questions) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption1(question.getOption2());
			wrapper.setOption1(question.getOption3());
			wrapper.setOption1(question.getOption4());
			wrappers.add(wrapper);
		}
		
		return new ResponseEntity<>(wrappers, HttpStatus.OK);	}

	@Override
	public ResponseEntity<Integer> getScore(List<Response> responses) {
		return null;
	}
}
