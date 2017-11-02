package com.nr.springmvc.controller;

import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nr.springmvc.model.EnteredSolution;
import com.nr.springmvc.model.Question;
import com.nr.springmvc.model.QuestionOption;
import com.nr.springmvc.model.QuestionResult;
import com.nr.springmvc.model.QuestionRightOption;
import com.nr.springmvc.model.Student;
import com.nr.springmvc.question.service.AddQuestionService;

 

@Controller
public class MultiTest {
	     
	static  long lcount=0;	
	static long wronganswer=0,wrightanswer=0;
	int count=0;
	 int start=0,tnor=0,end=0,tor=1;
	
	
	
	@Autowired
	AddQuestionService addQuestionService;
	
	

	 
	 	
	@RequestMapping(value="/addQuestion")
	public String addForm(ModelMap model){
		System.out.println("MultiTest->addForm");
		Question addquestion=new Question();
		model.addAttribute("addquestion", addquestion);
		return "ADDQ";
	}
	
	
	@RequestMapping(value="/addquestionform")
	public String addQForm(@ModelAttribute("addquestion")Question addquestion,BindingResult result,ModelMap map){
		System.out.println("MultiTest->addForm");
		System.out.println("=================================");
		System.out.println(addquestion.getQuestion());
		String quest=addquestion.getQuestion();
		String chaptername=addquestion.getChaptername();
		String subjectname=addquestion.getSubjectname();
		quest=quest.trim();
		
		 split(quest);
		System.out.println("=================================\t"+quest);
		
		Question q=new Question(chaptername,subjectname,quest);
		
		//Question q=new Question(quest,addquestion.getQrightoption(),addquestion.getQoption());
		QuestionRightOption qroption=new QuestionRightOption(addquestion.getQrightoption().getQroption1(), addquestion.getQrightoption().getQroption2(), addquestion.getQrightoption().getQroption3(), addquestion.getQrightoption().getQroption4());
		QuestionOption qoption=new QuestionOption(addquestion.getQoption().getQoption1(),addquestion.getQoption().getQoption2(),addquestion.getQoption().getQoption3(),addquestion.getQoption().getQoption4());
		System.out.println(addquestion);
		q.setQoption(qoption);
		q.setQrightoption(qroption);
 
		
		System.out.println(q);
		addQuestionService.addQuestion(q);
		
		return "ADDQSUCESS";
		
	}
	
	 String split(String question){
             String s[]=question.split("\\n");
             for(String ss:s){
            	 System.out.println(ss);
             }
		return null;
	}
	  
	 
	
	
	
	
	 
	@RequestMapping(value={"/taketest1-{chaptername}"},method=RequestMethod.GET)
	public String takeTestform(@PathVariable("chaptername")String chaptername,ModelMap model,HttpServletRequest req){
		 System.out.println("MultiTest->takeTest()"+chaptername);
		 List<String> rightoption=new ArrayList<String>();
	HttpSession ses=req.getSession();
	 List<Question> listallquestion=addQuestionService.getQuestion(chaptername);	
	 Question addq=new Question();
	 tnor=listallquestion.size();
	 
	 Question  listquestion=addQuestionService.getNextQuestion(start,tor);
 
	if(listquestion==null){
		System.out.println("=============     null                        ===============");
	 
		if(tnor<1){
			model.addAttribute("NOTFOUND","no records found");
		}
		return "studRegistrationList";
	}else{
		  	 	  
		
		 QuestionRightOption qro=listquestion.getQrightoption();
		    String question=listquestion.getQuestion();
		    System.out.println("````````````````````````````````````````````````````");
		    System.out.println(listallquestion.size());
		    System.out.println(question);
		    
		    
		    System.out.println("````````````````````````````````````````````````````");
		    int count=countrightoption(qro);
		    System.out.println("============================================");
		    System.out.println("count\t"+count);
		    System.out.println("============================================");
		    end=start+tor;
		 		  
		    
		    System.out.println("else part"+end+"\t"+tnor+"\t"+tor);
		    
		    if(end>tnor){
		 
		    end=tnor;
		    }
		 	
		 
		
		model.addAttribute("QUEST",addq);
		 
		 model.addAttribute("CHAPTERNAME", chaptername);
		ses.setAttribute("QUES", question);
		ses.setAttribute("loggedinuser", getPrincipal());
		ses.setAttribute("li", listquestion);
		ses.setAttribute("QOPT", rightoption);
		ses.setAttribute("BEGIN", start+1);
		ses.setAttribute("END", end);
		ses.setAttribute("TNOR",tnor); 
		ses.setAttribute("COUNT", count);
				setNext(model,req);
				if(tnor>end){
					ses.setAttribute("SHOW_NEXT","OK");
					
				}
				
		}
					
	 		
			return "TEST";
} 

	
	@RequestMapping(value={"/checksol"},method=RequestMethod.POST)
	public String checksloution(@ModelAttribute("QUEST")Question q,ModelMap model,HttpServletRequest req){
		HttpSession ses=req.getSession();

		System.out.println("MultiTest->checkSolution()"+q);
		 Integer i=(Integer)ses.getAttribute("END");
		  start=i.intValue();
		  System.out.println("start"+start);
		  Integer begin=(Integer)ses.getAttribute("BEGIN");
		  System.out.println("Begin->"+begin);
		  Integer itnor=(Integer)ses.getAttribute("TNOR");
		  System.out.println("TNOR->"+itnor);
		
		
		
		try{
		if(q.equals(null)){
			System.out.println();
			req.setAttribute("ANS", "select the answer");
			return "TEST";
		}else if(!(q.equals(null))) {
		String quest=q.getQuestion();
		
		 
		List<String> enterdsolution=q.getEnteredsolution();
		
		boolean b=addQuestionService.checksolution(q);
		System.out.println("MultiTest->checksolution->"+b);
		model.addAttribute("CHAPTERNAME", q.getChaptername());
		if(b){
			QuestionResult.setCorrectAnswer(++lcount);
			QuestionResult.getCorrectAnswer();
			 wrightanswer=QuestionResult.getCorrectAnswer();
			 System.out.println(wrightanswer);
			ses.setAttribute("CORRECTANSWER",wrightanswer);
			req.setAttribute("SOL","u are correct" );
		}else{
			
			QuestionResult.setWrongAnswer(++lcount);
			wronganswer=QuestionResult.getWrongAnswer();
			model.addAttribute("WROONGANSWER",wronganswer);
			model.addAttribute("WSOL", "u are wrong");
		}
		System.out.println("wrong answer\t"+wronganswer);
		return "TEST";
		}
		
		}catch (Exception e) {
	e.printStackTrace();
		}
		return "TEST";
	}
	
	
	
 @RequestMapping(value={"/listQuestionNext"},method=RequestMethod.GET)
public String listQuestionNext(@ModelAttribute("QUEST")Question quest,ModelMap model,HttpServletRequest req){
	 String chaptername=quest.getChaptername();
	 System.out.println("MultiTest->listQuestionNext()"+chaptername);
	//List<Student> li=studentService.findAllUser();
	 HttpSession ses=req.getSession();
	 
	 Integer i=(Integer)ses.getAttribute("END");
	  start=i.intValue();
	  System.out.println("start"+start);
	  Integer begin=(Integer)ses.getAttribute("BEGIN");
	  System.out.println("Begin->"+begin);
	  Integer itnor=(Integer)ses.getAttribute("TNOR");
	  System.out.println("TNOR->"+itnor);
	  
	 
	  
	  System.out.println("LoginController->showNextDate()"+tnor);
	 Question q=new Question();
	 q.setChaptername(chaptername);
	 List<Question> listallquestion=addQuestionService.getQuestion(chaptername);
	 tnor=listallquestion.size();
	 System.out.println("TNOR->"+tnor);
	 Question  listofquestion=addQuestionService.getNextQuestion(start,tor);
	 System.out.println(listofquestion);
	 
	 	 if(listofquestion==null){
	 System.out.println("MultiTest->listquestionNext()->null");	 		  
	 	  
	  if(tnor<1){
		  model.addAttribute("NOT_FOUND", "not found");
	  }
	  }else{
		  end=start+tor;
		  System.out.println("end value"+end);
		  QuestionRightOption qro=listofquestion.getQrightoption();
		   
		    int count=countrightoption(qro);
		    
		    
		     
		    String question=listofquestion.getQuestion();
		    
		    
		    
		  if(end>tnor){
			  end=tnor;
		  }
		  start=start+1;
		  
		  System.out.println("*******************************************************************");
		  System.out.println(count);
		  System.out.println("*******************************************************************");
		  
		  System.out.println("start+1"+"\t"+(start)+"\t"+"end\t"+end+"tnor\t"+tnor);
		  System.out.println("````````````````````````````````````````````````````");
		    System.out.println(question);
		    System.out.println("````````````````````````````````````````````````````");
		  
		    model.addAttribute("CHAPTERNAME", chaptername);
		  ses.setAttribute("QUES", question);
		  ses.setAttribute("li", listofquestion);
			 ses.setAttribute("BEGIN", start);
			 ses.setAttribute("END", end);
			 ses.setAttribute("TNOR", tnor);
			 ses.setAttribute("COUNT", count);
			 setNext(model,req);
	  }
	   
	 		 
	  
	 
			return "TEST";
}

 
 @RequestMapping(value={"/listQuestionPrev"},method=RequestMethod.GET)
public String listQuestionPrev(@ModelAttribute("QUEST")Question q,ModelMap model,HttpServletRequest req){
	 String chaptername=q.getChaptername();
	 System.out.println("MultiTest->listQuestionPrev()"+chaptername);	 		
	 
	 HttpSession ses=req.getSession();
	 List<Question> listofStudent=addQuestionService.getQuestion(chaptername);
	Integer i=(Integer)ses.getAttribute("END");
	System.out.println("ENDVALUE->"+i);
	System.out.println("torvalue->"+tor);
	 QuestionOption qoption=null;
	 start=i.intValue()-tor-1;
	 
	 
	 
	 
	 System.out.println(start);
	  tnor=listofStudent.size();
	  System.out.println("MultiTest->listQuestionPrev()"+tnor);
	  Question  listofquestion=addQuestionService.getPreviousQuestion(start,tor);
	  if(listofquestion==null){
		  System.out.println("multiTest->listquestionprev()->empty");
	  if(tnor<1){
		  model.addAttribute("NOT_FOUND", "not found");
	  }
	  }else{
		  
		  String question=listofquestion.getQuestion();
		  QuestionRightOption qro=listofquestion.getQrightoption();
		    System.out.println(qro);
		    int count=countrightoption(qro);
		     
		  
		  
		   		  if(tnor<1){
			  model.addAttribute("NOT_FOUND", "not found");
		  }
		  
		  end=start+tor;
		  System.out.println("end value"+end);
		  if(end>tnor){
			  end=tnor;
		  }
		  
		  System.out.println("*******************************************************************");
		  System.out.println(count);
		  System.out.println("*******************************************************************");
		  model.addAttribute("CHAPTERNAME", chaptername);
		  ses.setAttribute("QUES", question);
		  ses.setAttribute("li", listofquestion);
		  ses.setAttribute("QOPT", qoption);
			 ses.setAttribute("BEGIN", start+1);
			 ses.setAttribute("END", end);
			 ses.setAttribute("TNOR", tnor);
			 ses.setAttribute("COUNT", count);
			 setNext(model,req);
	  }
 
		return "TEST";
} 
 

private void setNext(ModelMap model,HttpServletRequest req){
	  if(start+1>=1){
		  model.addAttribute("SHOW_PREVIOUS", "ok");
	  }
	  if(end<tnor){
		  model.addAttribute("SHOW_NEXT", "ok");
	  }
 }
	

 

	
private String getPrincipal(){
	String userName=null;
	Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if(principal instanceof UserDetails){
		userName=((UserDetails)principal).getUsername();
	}else{
		userName=principal.toString();
	}
	return userName;
}


private int countrightoption(QuestionRightOption qro){
	int count=0;
	if(qro!=null){
	if(qro.getQroption1()!=null&&!(qro.getQroption1().isEmpty())){
		count++;
	}
	if(qro.getQroption2()!=null&&!(qro.getQroption2().isEmpty())){
		count++;
	}
	if(qro.getQroption3()!=null&&!(qro.getQroption3().isEmpty())){
		count++;
	}
	if(qro.getQroption4()!=null&&!(qro.getQroption4().isEmpty())){
		count++;
	}
	}else{
		return count;
	}
	
	return count;
}


/*
 related to the chapter levelt test
 */

@RequestMapping(value="/chapterlevel")
public String chapterLevel(ModelMap map){
	
	
	
	return "CHAP";
}





}
