package com.nr.springmvc.question.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nr.springmvc.dao.AbstractDao;
import com.nr.springmvc.model.EnteredSolution;
import com.nr.springmvc.model.Question;
import com.nr.springmvc.model.QuestionOption;
import com.nr.springmvc.model.QuestionResult;
import com.nr.springmvc.model.QuestionRightOption;
@Repository("addQuestionDao")
@Transactional
public class AddQuestionDaoImpl extends AbstractDao<Long,Question> implements AddQuestionDao{
	
	@Override
	public void addQuestion(Question addquestion) {
		
		 
		
	 persist(addquestion);
		
	}

	public List<Question> getQuestion(String chaptername){
		Criteria criteria=createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("chaptername",chaptername));
		List<Question> list=criteria.list();
		List<Question> listofquestion=new ArrayList<Question>();
		QuestionOption qoption=null;
		QuestionRightOption qroption=null;
		for(Question q:list){
			  //Question qu=new Question(q.getQidnum(), q.getQuestion(),q.getQrightoption(),q.getQoption(), q.getEnteredsolution());
			  Question qu=new Question(q.getQidnum(),q.getChaptername(),q.getSubjectname(),q.getQuestion());
		 qoption=new QuestionOption(q.getQidnum(),q.getQoption().getQoption1(),q.getQoption().getQoption2(),q.getQoption().getQoption3(),q.getQoption().getQoption4());
		 qroption=new QuestionRightOption(q.getQrightoption().getQrightoptionid(),q.getQrightoption().getQroption1(),q.getQrightoption().getQroption2(),q.getQrightoption().getQroption3(),q.getQrightoption().getQroption4());
		 qu.setQoption(qoption);
		 qu.setQrightoption(qroption);
			List<String> entersolution=q.getEnteredsolution();
		 
			 
			 qu.setEnteredsolution(entersolution);
			 System.out.println("----------------------------------");
			 System.out.println(qu);
			 System.out.println("----------------------------------");  
			 listofquestion.add(qu);
			
			
		}
		System.out.println("***************************************");
		System.out.println(listofquestion);
		System.out.println("***************************************");
		 
		return listofquestion;
	}
	
	/*public List<Question> getNextQuestion(int start){
		Criteria criteria=createEntityCriteria();
		 criteria.setFirstResult(start);
		 List<Question> list=criteria.list();
		 return getQuestion();
	}*/
	
	
	 public Question getNextQuestion(int start,int total){
		// Long id=new Long(1);
		 List<Question> listofquestion=new ArrayList<Question>();
		 
		 System.out.println("AddQuestionDAOIMpl->getNextQuestion()"+start+"\t"+total);
		Criteria criteria=createEntityCriteria();
		  
		 criteria.setFirstResult(start);
		 criteria.setMaxResults(1);
		 List<Question> list=criteria.list();
		 System.out.println("AddQuestionDaoImpl->getNextQuestion()"+list.size());
		 
		 
		 Question qu=null;
		 QuestionOption qoption=null;
			QuestionRightOption qroption=null;
		 
			for(Question q:list){
				qu=new Question(q.getQidnum(),q.getChaptername(),q.getSubjectname(),q.getQuestion()); 
				//qu=new Question(q.getQidnum(), q.getQuestion(),q.getQrightoption(),q.getQoption()); 
			 qoption=new QuestionOption(q.getQidnum(),q.getQoption().getQoption1(),q.getQoption().getQoption2(),q.getQoption().getQoption3(),q.getQoption().getQoption4());
			 qroption=new QuestionRightOption(q.getQrightoption().getQrightoptionid(),q.getQrightoption().getQroption1(),q.getQrightoption().getQroption2(),q.getQrightoption().getQroption3(),q.getQrightoption().getQroption4());
		 
			 qu.setQoption(qoption);
			 qu.setQrightoption(qroption);
			 
		 
		   
				 System.out.println("----------------------------------");
				 System.out.println(q);
				 System.out.println("----------------------------------");
				 listofquestion.add(qu);
				
				
			}
		 
		 return qu;
	} 
	
	 
	 
	 
	 @Override
	public boolean checksolution(Question q) {
		   
		 System.out.println("AddQuestionDaoImpl->checksolution()");
		 String ques=q.getQuestion();
		 
		 
		 Criteria c=createEntityCriteria();
		 c.add(Restrictions.eq("qidnum",q.getQidnum()));
		 c.add(Restrictions.eq("question", ques));
		 
		 
		 Question quesobj=(Question)c.uniqueResult();
		  QuestionRightOption qro=quesobj.getQrightoption();
		 System.out.println("*******"+qro+"**************");
		 
		List<String> set=q.getEnteredsolution();
		System.out.println("AddQuestionDaoImpl->checksolution()\t"+set);
		 
		  Iterator it=set.iterator();
		 
		 while(it.hasNext()){
			String es=(String)it.next();
			System.out.println("AddQuestionDaoImpl->checksolution()\t"+es);
			if(qro.getQroption1()!=null&&!(qro.getQroption1().isEmpty())&&qro.getQroption1().equals(es)){
			 
				System.out.println("AddQuestionDaoImpl->checksolution()->while()->if\t"+true);
				if(qro.getQroption2()!=null&&!(qro.getQroption2().isEmpty())&&qro.equals(es)){
					if(qro.getQroption3()!=null&&!(qro.getQroption3().isEmpty())&&qro.equals(es)){
						if(qro.getQroption4()!=null&&!(qro.getQroption4().isEmpty())&&qro.equals(es)){
							return true;
						}
						System.out.println(true);
						return true;
					}
					System.out.println(true);
					return true;
				}
				System.out.println(true); 
			 return true;
		 }
			 
		 
		 } 
		 
		 
		 
		 
		  /*if(qro.getQroption1().equals(q.getEnteredsolution())){
			  
			  if(qro.getQroption2()!=null&&!(qro.getQroption2().isEmpty())){
				   
				  
				  if(qro.getQroption3()!=null&&!(qro.getQroption3().isEmpty())){
					  
					  if(qro.getQroption4()!=null&&!(qro.getQroption4().isEmpty())){
					
						  
					  }
				  }
			  }
//		*/	    
			  return false;
		  }
		 
		  
		 
	 
	 @Override
	public Question getPreviousQuestion(int start, int total) {
	 System.out.println("AddQuestionDaoImpl->getPreviousQuestion()");
	 Question q=null;
	 Criteria c=createEntityCriteria();
	 c.setFirstResult(start);
	 c.setMaxResults(total);
	 List<Question> quet=(List<Question>)c.list();
	 for(Question qq:quet){
		 QuestionRightOption qro=new QuestionRightOption(qq.getQrightoption().getQrightoptionid(),qq.getQrightoption().getQroption1(),qq.getQrightoption().getQroption2(),qq.getQrightoption().getQroption3(),qq.getQrightoption().getQroption4());
		 QuestionOption qo=new QuestionOption(qq.getQoption().getQoption1(), qq.getQoption().getQoption2(), qq.getQoption().getQoption3(), qq.getQoption().getQoption4());
		 q=new Question(qq.getQidnum(),qq.getChaptername(),qq.getSubjectname(),qq.getQuestion());
		   q.setQrightoption(qro);
		   q.setQoption(qo);
		// q=new Question(qq.getQidnum(),qq.getQuestion(),qro,qo);
		  
	 }
	 if(q!=null){
		 System.out.println("AddQuestionDaoImpl->"+q);
		 return q;
	 }
	 
	 
	
		 
		 
		return null;
	}
	
}
