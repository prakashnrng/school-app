package com.nr.springmvc.controller;

 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

 
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nr.springmvc.model.Fee;
import com.nr.springmvc.model.Student;
import com.nr.springmvc.model.StudentDocument;
import com.nr.springmvc.model.User;
import com.nr.springmvc.model.UserProfile;
import com.nr.springmvc.service.UserProfileService;
import com.nr.springmvc.service.UserService;
import com.nr.springmvc.student.service.StudentService;

 

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class SchoolAppController {
	
	
	int count=0;
	 int start=0,tnor=0,end=0,tor=5;
	static{
		System.out.println("AppController->s.b");
	}
	
	
	@Autowired
	StudentService studentService;

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	Logger logger=LoggerFactory.getLogger(SchoolAppController.class);
	
	
	
	@RequestMapping(value={"/feePaymentDetails"})
	public String feePayment(){
		logger.info("SchoolAppController->FeePayment()");
		
		return "feePaymentDetails";
	}
	
	@RequestMapping(value="/studentSearch")
	public String studentSearch(){
		logger.info("SchollAppCOntroller->studentSearch()");
		return "studentSearch";
	}
	
	@RequestMapping(value="/feepaymentRecipts")
	public String feePaymentRecipt(){
		logger.info("SchoolAppCOntroller->feePayment()");
		return "feepaymentRecipts";
	}
	
	@RequestMapping(value={"/addStudent"},method=RequestMethod.GET)
	public String addStudent(ModelMap model){
		logger.info("SchollAppCOntroller->addStudent()");
		Student stu=new Student();
		model.addAttribute("stu",stu);
		model.addAttribute("loggedinuser", getPrincipal());
		return "addStudent";
	}
	
	 @RequestMapping(value={"/addStudent"},method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("stu")@Valid Student student,BindingResult result,ModelMap model) throws ParseException{
		logger.info("SchollAppCOntroller->saveStudent()");
		logger.info("SchollAppCOntroller->saveStudent()"+student);
		
		
		List<String> installment=student.getFee().getNoOfInstallments();
		String date=student.getFee().getFeePayDate();
		//List<Date> d=student.getFee().getDuedate();
		List<Date> d=new ArrayList<Date>();
		for(String str:installment){
		if(str.equals("1->installment")){
			System.out.println("SchoolAppController=>saveStudent()");
		/*	Date dd;
DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
dd=dateFormat.parse(date);

 dd.setMonth(2);
 System.out.println("+++++++++++++++++++++++++++++++++++++++"+dd);
 d.add(dd);*/
			
			Date dd=new Date();
			 Calendar cal = Calendar.getInstance(); 
			
			cal.add(Calendar.MONTH, 2);
			dd=cal.getTime();
			 d.add(dd);
			Fee f=student.getFee();
						f.setDuedate(d);
			student.setFee(f);
	
			 
		
		}else if(str.equals("2->installment")){
			System.out.println("SchoolAppController=>saveStudent()");
			/*	Date dd;
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	dd=dateFormat.parse(date);

	 dd.setMonth(2);
	 System.out.println("+++++++++++++++++++++++++++++++++++++++"+dd);
	 d.add(dd);*/
				
				Date dd=new Date();
				 Calendar cal = Calendar.getInstance(); 
				
				cal.add(Calendar.MONTH, 2);
				dd=cal.getTime();
				 d.add(dd);
				 cal.add(Calendar.MONTH, 4);
				 dd=cal.getTime();
				 d.add(dd);
				Fee f=student.getFee();
							f.setDuedate(d);
				student.setFee(f);
		}else if(str.equals("3->installment")){
			System.out.println("SchoolAppController=>saveStudent()");
			/*	Date dd;
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	dd=dateFormat.parse(date);

	 dd.setMonth(2);
	 System.out.println("+++++++++++++++++++++++++++++++++++++++"+dd);
	 d.add(dd);*/
				
				Date dd=new Date();
				 Calendar cal = Calendar.getInstance(); 
				
				cal.add(Calendar.MONTH, 2);
				dd=cal.getTime();
				 d.add(dd);
				 cal.add(Calendar.MONTH, 4);
					dd=cal.getTime();
					 d.add(dd);
					 cal.add(Calendar.MONTH, 6);
						dd=cal.getTime();
						 d.add(dd);
						 					 
				Fee f=student.getFee();
							f.setDuedate(d);
				student.setFee(f);
		}
		
		
		
		 if(result.hasErrors()){
			 model.addAttribute("loggedinuser", getPrincipal());
			return "addStudent";
		} 
		
		studentService.saveStudent(student);
		
		model.addAttribute("studsuccess", "student"+student.getStudentFirstName()+""+student.getStudentLastName()+"registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		 
		
		
	} 
		return "studRegistrationSuccess";
	 }
	
	@RequestMapping(value={"/listofStudent"},method=RequestMethod.GET)
	public String listStudent(ModelMap model,HttpServletRequest req){
		 
		HttpSession ses=req.getSession();
		 List<Student> listofrecords=studentService.findAllUser();
		 
		 for(Student st:listofrecords){
			 System.out.println(st);
			 System.out.println(st.getFee());
			 System.out.println(st.getFee().getNoOfInstallments());
			 System.out.println(st.getFee().getDuedate());
		 }
		 
		 tnor=listofrecords.size();
		 System.out.println(listofrecords);
	 	List<Student> listoutuser=studentService.findUser(start,tor);
	 	
		if(listoutuser==null){
			if(tnor<1){
				model.addAttribute("NOTFOUND","no records found");
			}
			return "studRegistrationList";
		}else{
			 end=start+tor;
			System.out.println("else part"+end+"\t"+tnor+"\t"+tor);
			if(end>tor){
			//	System.out.println("li"+listoutuser);
				end=tor;
			}
				 ses.setAttribute("loggedinuser", getPrincipal());
					ses.setAttribute("li", listoutuser);
					ses.setAttribute("BEGIN", start+1);
					ses.setAttribute("END", end);
					ses.setAttribute("TNOR",tnor);
					setNextPrevious(model,req);
					if(tnor>end){
						ses.setAttribute("SHOW_NEXT","OK");
						
					}
					
			}
						
		 		
				return "studRegistrationList";
	}
	
	@RequestMapping(value={"/listofStudentnext"},method=RequestMethod.GET)
	public String listStudentNext(ModelMap model,HttpServletRequest req){
		//List<Student> li=studentService.findAllUser();
		 HttpSession ses=req.getSession();
		 
		 Integer i=(Integer)ses.getAttribute("END");
		  start=i.intValue();
		  System.out.println(start);
		  
		  System.out.println("LoginController->showNextDate()"+tnor);
		 
		 List<Student> listofrecord=studentService.findAllUser();
		 tnor=listofrecord.size();
		 List<Student> listofuser=studentService.findUser(start,tor);
		 System.out.println(listofuser);
		 	 if(listofuser==null){
		 		 
		 	  
		  if(tnor<1){
			  model.addAttribute("NOT_FOUND", "not found");
		  }
		  }else{
			  end=start+tor;
			  System.out.println("end value"+end);
			  if(end>tnor){
				  end=tnor;
			  }
			  ses.setAttribute("li", listofuser);
				 ses.setAttribute("BEGIN", start+1);
				 ses.setAttribute("END", end);
				 ses.setAttribute("TNOR", tnor);
				 setNextPrevious(model,req);
		  }
		   
		 		 
		  
		 
				return "studRegistrationList";
	}
	
	
	@RequestMapping(value={"/listofStudentprev"},method=RequestMethod.GET)
	public String listStudentPrevious(ModelMap model,HttpServletRequest req){
		HttpSession ses=req.getSession();
		 List<Student> listofStudent=studentService.findAllUser();
		Integer i=(Integer)ses.getAttribute("END");
		 
		 start=i.intValue()-tor-5;
		 if(start<0){
			  model.addAttribute("NOT_FOUND", "not found");  
		  }
		 
		 System.out.println(start);
		  tnor=listofStudent.size();
		  System.out.println("LoginController->showNextDate()"+tnor);
		  List<Student> li=studentService.findUser(start,tor);
		  if(li==null){
		  if(tnor<1){
			  model.addAttribute("NOT_FOUND", "not found");
		  }
		  }else{
			  if(tnor<1){
				  model.addAttribute("NOT_FOUND", "not found");
			  }
			  
			  end=start+tor;
			  System.out.println("end value"+end);
			  if(end>tnor){
				  end=tnor;
			  }
			  ses.setAttribute("li", li);
				 ses.setAttribute("BEGIN", start+1);
				 ses.setAttribute("END", end);
				 ses.setAttribute("TNOR", tnor);
				 setNextPrevious(model,req);
		  }
		
			return "studRegistrationList";
	}
	
	
	private void setNextPrevious(ModelMap model,HttpServletRequest req){
		  if(start+1>5){
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
	
	
	
	@ModelAttribute("section")
	public List<String> listofSection(){
		List<String> list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		return list;
		
	}
	
	
	@ModelAttribute("numberofinstallments")
	public List<String> listOfInstallment(){
		List<String> list=new ArrayList<String>();
		list.add("default");
		list.add("1->installment");
		list.add("2->installment");
		list.add("3->installment");
		return list;
	}
	
	

	
	
	@RequestMapping("feePaymentDetailsForm")
	public String feePaymentform(ModelMap model){
		//System.out.println("SchoolAppController=>Fee");
		logger.info("SchoolAppController->feePayment()");
		
		Student student=new Student();
		model.addAttribute("student", student);
		return "FEEDETAILS";
	}
	 
	@RequestMapping(value={"/feePaymentD"},method=RequestMethod.POST)
	public String feePaymentAction(@ModelAttribute("student")Student stud,ModelMap model,BindingResult result,HttpServletRequest req){
		
			//Map<String,Double> feedetials=studentService.feePaymntDetails(stud);
	List<Student> li=studentService.feePaymntDetails(stud);
		if(li!=null)
		 for(Student st:li){
			 if(st.getFee()!=null){
			//System.out.println(st);
			//Fee f=st.getFee();
			//System.out.println(f);
			
			 }
		} 
		
		
		/*Set set=feedetials.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			Map.Entry<String, Double> mapentry=(Map.Entry<String, Double>)it.next();
			String st=mapentry.getKey();
			Double d=mapentry.getValue();
			
		if(st.equals("feeBal")){
			
		}
		}*/
		
		/*double totfeeBal=feedetials.get("feeBal");
		double totfeePaid=feedetials.get("feePaid");
		
		model.addAttribute("TFEEBAL", totfeeBal);
		model.addAttribute("TFEEPAID",totfeePaid);*/
		
		
		model.addAttribute("LISTSTUD", li);
		return "FEEDETAILSFORM";
	}
	
 
	 @RequestMapping(value = { "/download-stud-{studentId}" }, method = RequestMethod.GET)
	 public String downloadDocument(ModelMap model,@PathVariable Long studentId, HttpServletResponse response) throws IOException, DocumentException, com.itextpdf.text.DocumentException {
        Student sud = studentService.findStudentById(studentId);
        
      /*  double duefee=sud.getFee().getFeeBal();
        List<String> installment=sud.getFee().getNoOfInstallments();
        Date dueDate=new Date();
        
        if(duefee!=0){
        	if(installment=="1->installment"){
        		 int month=dueDate.getMonth();
        		 dueDate=dueDate.getMonth()+3;
        	}
        		
        	 
        }*/
        
          model.addAttribute("SUD", sud);
        Document document=new Document();
		String fileName=sud.getFatherLastName()+".pdf";
		//Document Attributes
		document.addAuthor("prakash ");
		  
		document.addCreator("School App");
		document.addTitle("School App");
        document.addCreationDate();
		String filePath="C:/pdf/"+fileName;
 
		File file = new File(filePath);

		PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(filePath));
		document.open();

		PdfPTable table = new PdfPTable(2);

		table.setSpacingBefore(5);
		table.setSpacingAfter(1);
        
		
		table.setTotalWidth(PageSize.A4.getWidth()-10);
		table.setLockedWidth(true);
		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);

		Font schoolFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLDITALIC);
		PdfPCell c1 = new PdfPCell(new Phrase("FEE"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.CYAN);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("DETAILS"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase("STUDENTID"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase(sud.getStudentId()+"", schoolFont));
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("STUDENTFIRSTNAME"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		
		
		c1 = new PdfPCell(new Phrase(sud.getStudentFirstName()+"", schoolFont));
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("STUDENTLASTNAME"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase(sud.getStudentLastName()+"", schoolFont));
		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase("FATHERNAME"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase(sud.getFatherFirstName()+"", schoolFont));
		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase("MOTHERNAME"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase(sud.getMotherFirstName()+"", schoolFont));
		table.addCell(c1);
		
		 
		
		c1 = new PdfPCell(new Phrase("GRADE"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		c1 = new PdfPCell(new Phrase(sud.getGrade()+"", schoolFont));
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("GENDER"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase(sud.getGender()+"", schoolFont));
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("SECTION"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase(sud.getSection()+"", schoolFont));
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("ACADEMICYEAR"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase(sud.getAcademicYear()+"", schoolFont));
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("TOTALFEE"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase(sud.getFee().getTotalFeeAmount()+"", schoolFont));
		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase("FEEPAID"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase(sud.getFee().getFeePaid()+"", schoolFont));
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("FEEBAL"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		
		
		
		c1 = new PdfPCell(new Phrase(sud.getFee().getFeeBal()+"", schoolFont));
		c1.setBackgroundColor(BaseColor.RED);
		table.addCell(c1);

		
		
		
		
		/*
		
		c1 = new PdfPCell(new Phrase("DUEDATE"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.ORANGE);
		//c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		*/
		
		/*List<Date> list=sud.getFee().getDuedate();
		for(Date date:list){
		c1 = new PdfPCell(new Phrase(date+"", schoolFont));
		}
		c1.setBackgroundColor(BaseColor.RED);
		table.addCell(c1);

		
				
		
		c1 = new PdfPCell(new Phrase("FEEPAYDATE"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.PINK);
		
		c1.setBackgroundColor( new BaseColor (90, 137, 9));

		table.addCell(c1);
		c1 = new PdfPCell(new Phrase(sud.getFee().getFeePayDate()+"", schoolFont));
		
		table.addCell(c1);
		
		*/
		
		c1=new PdfPCell(new Phrase("DUEDATE"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.PINK);
		 table.addCell(c1);
		 
		/* List<Date> d=sud.getFee().getDuedate();
		 for(Date dd:d){*/
		 c1=new PdfPCell(new Phrase(sud.getFee().getDuedate()+"",schoolFont));
		  table.addCell(c1);
		document.add(table);
		document.close();
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");

		
		byte[] bytes=FileUtils.readFileToByteArray(file);
		
		FileCopyUtils.copy(bytes, response.getOutputStream());
		 
		OutputStream os = response.getOutputStream();
 
        
        /*response.setContentType("application/pdf");
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
  
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());
  
        return "redirect:/add-document-"+userId;*/
        
		model.addAttribute("loggedinuser", getPrincipal());
		
		
        return "DOWNLOADPDF";
    }  
	
	/*@RequestMapping(value = { "/download-document-{${studentId}}" }, method = RequestMethod.GET)
    public String downloadDocument(ModelMap model,@PathVariable Long studentId, HttpServletResponse response) throws IOException {
        Student sud = studentService.finById(studentId);
        
        response.setContentType("application/pdf");
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
  
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());
  
        return "redirect:/add-document-"+userId;
    } */
	
	 
	
	
	
	
	
	
	 /* @RequestMapping(value = { "/download-document-{${studentId}}" }, method = RequestMethod.GET)
    public String downloadDocument(ModelMap model,@PathVariable Long studentId, HttpServletResponse response) throws IOException {
        Student sud = studentService.finById(studentId);
        
        response.setContentType("application/pdf");
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
  
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());
  
        return "redirect:/add-document-"+userId;
    }  */
	  
	
	
	@ModelAttribute("listofgrade")
	public List<String> listGrade(ModelMap model){
		logger.info("SchoolAppController->listOfGrade()");
		List<String> li=new ArrayList<String>();
		li.add("Lkg");
		li.add("Ukg");
		li.add("class-1");
		li.add("class-2");
		li.add("class-3");
		li.add("class-4");
		li.add("class-5");
		li.add("class-6");
		li.add("class-7");
		li.add("class-8");
		li.add("class-9");
		li.add("class-10");
		return li;
	}
	
	
	
 @ModelAttribute("academicyor")
 public List<String> aYear(ModelMap model){
	 logger.info("SchoolAppController->aYear()");
	 List<String> list=new ArrayList<String>();
	 list.add("2016-17");
	 list.add("2017-18");
	 list.add("2018-19");
	 return list;
 }
	

}