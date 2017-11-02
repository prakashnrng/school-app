package com.nr.springmvc.question.dao;

import java.util.List;

import com.nr.springmvc.model.Question;

public interface AddQuestionDao {
	
	void addQuestion(Question addquestion);
	List<Question> getQuestion(String chaptername);
	
	//public List<Question> getNextQuestion(int start);
	public Question getNextQuestion(int start,int total);
	
	public boolean checksolution(Question q);
	
	public Question getPreviousQuestion(int start,int total);
	
}
