package com.quizproject.questionservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizproject.questionservice.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
	
	public List<Question> findByCategory(String category);
	
	@Query(value="select id from question where category=:categoryName order by Rand() limit :numOfQ", nativeQuery=true)
	public List<Integer> findRandomQuestionsByCategory(String categoryName, Integer numOfQ);
	
}
