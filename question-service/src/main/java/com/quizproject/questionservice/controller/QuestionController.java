package com.quizproject.questionservice.controller;

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

import com.quizproject.questionservice.model.Question;
import com.quizproject.questionservice.model.QuestionWrapper;
import com.quizproject.questionservice.model.Response;
import com.quizproject.questionservice.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{cate}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("cate") String category){
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question){
		return questionService.addQuestion(question);
	}
	
//	@GetMapping("delete/{id}")
//	public ResponseEntity<String> deleteQuestion(@PathVariable("id") Integer id){
//		return questionService.deleteQuestion(id);
//	}
	
	@PostMapping("update/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable("id") Integer id, @RequestBody Question question){
		return questionService.updateQuestion(id, question);
	}
	
	//generate
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numOfQ){
		return questionService.getQuestionsForQuiz(categoryName, numOfQ);
	}
	//getQuestions{questionID}
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionId){
		return questionService.getQuestionsFromId(questionId);
	}
	//getScore
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		return questionService.getScore(responses);
	}
	
}
