package com.quizproject.questionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizproject.questionservice.dao.QuestionDao;
import com.quizproject.questionservice.model.Question;
import com.quizproject.questionservice.model.QuestionWrapper;
import com.quizproject.questionservice.model.Response;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions(){
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category){
		return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
	}
	
	public ResponseEntity<String> addQuestion(Question question){
		questionDao.save(question);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
	
//	public ResponseEntity<String> deleteQuestion(Integer id){
//		questionDao.deleteById(id);
//		return new ResponseEntity<>("Success", HttpStatus.OK);
//	}
	
	public ResponseEntity<String> updateQuestion(Integer id, Question question){
		question.setId(id);
//		question.setCategory(question.getCategory());
//		question.setQuestionTitle(question.getQuestionTitle());
//		question.setOption1(question.getOption1());
//		question.setOption2(question.getOption2());
//		question.setOption3(question.getOption3());
//		question.setOption4(question.getOption4());
//		question.setRightAnswer(question.getRightAnswer());
//		question.setDifficultLevel(question.getDifficultLevel());
		questionDao.save(question);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numOfQ){
		List<Integer> questions=questionDao.findRandomQuestionsByCategory(categoryName, numOfQ);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionId){
		List<QuestionWrapper> wrappers=new ArrayList();
		List<Question> questions=new ArrayList();
		
		for(Integer id:questionId) {
			questions.add(questionDao.findById(id).get());
		}
		
		for(Question question:questions) {
			QuestionWrapper qwrapper=new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
			wrappers.add(qwrapper);
		}
		
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}
	
	public ResponseEntity<Integer> getScore(List<Response> responses){
		int right=0;
		
		for(Response re:responses) {
			Question question=questionDao.findById(re.getId()).get();
			if(re.getResponse().equals(question.getRightAnswer())) {
				right++;
			}
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
	
}
