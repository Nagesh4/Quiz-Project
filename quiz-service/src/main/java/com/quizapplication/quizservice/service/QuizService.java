package com.quizapplication.quizservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapplication.quizservice.dao.QuizDao;
import com.quizapplication.quizservice.feign.QuizInterface;
import com.quizapplication.quizservice.model.QuestionWrapper;
import com.quizapplication.quizservice.model.Quiz;
import com.quizapplication.quizservice.model.Response;
//dto = data transfer object
@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;
	
	public ResponseEntity<String> createQuiz(String category, Integer numOfQ, String title){
		List<Integer> questions=quizInterface.getQuestionsForQuiz(category, numOfQ).getBody();
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionsIDs(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer Id){
		Quiz quiz=quizDao.findById(Id).get();
		List<Integer> questionIds=quiz.getQuestionsIDs();
		ResponseEntity <List<QuestionWrapper>> questions=quizInterface.getQuestionsFromId(questionIds);
		return questions;
	}
	
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses){
		ResponseEntity<Integer> score=quizInterface.getScore(responses);
		return score;
	}
	
	public ResponseEntity<String> deleteQuiz(Integer id){
		quizDao.deleteById(id);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
}
