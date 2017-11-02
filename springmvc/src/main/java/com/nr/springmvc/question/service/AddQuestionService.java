package com.nr.springmvc.question.service;

import java.util.List;

import com.nr.springmvc.model.Question;

public interface AddQuestionService {
void addQuestion(Question addquestion);
public List<Question> getQuestion(String chaptername);
//public List<Question> getNextQuestion(int start);
 public Question getNextQuestion(int start,int total);
 public Question getPreviousQuestion(int start,int total);
 
 public boolean checksolution(Question q);  
 
}
