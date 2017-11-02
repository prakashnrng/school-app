package com.nr.springmvc.question.service;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nr.springmvc.model.Question;
import com.nr.springmvc.question.dao.AddQuestionDao;

@Service("addquestionservice")
public class AddQuestionServiceImpl implements AddQuestionService{
	
	@Autowired
	AddQuestionDao addQuestionDao;
	
	@Override
	public void addQuestion(Question addquestion) {
		addQuestionDao.addQuestion(addquestion);
		
	}

	
	public List<Question> getQuestion(String chaptername){
		
		return addQuestionDao.getQuestion(chaptername);
	}
	
		/*public List<Question> getNextQuestion(int start){
		
		return addQuestionDao.getNextQuestion(start);
	}
	*/
	
	
	 public Question  getNextQuestion(int start,int total){
		
		return addQuestionDao.getNextQuestion(start, total);
	} 
	 
	 @Override
	public boolean checksolution(Question q) {
	 
		return addQuestionDao.checksolution(q);
	}
	
	 
	 public Question getPreviousQuestion(int start,int total){
		 return addQuestionDao.getPreviousQuestion(start, total);
	 }
	 
	 
}
