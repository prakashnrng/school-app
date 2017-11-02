package com.nr.springmvc.student.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nr.springmvc.dao.AbstractDao;
import com.nr.springmvc.model.Fee;
import com.nr.springmvc.model.Marks;
import com.nr.springmvc.model.Student;
import com.nr.springmvc.model.User;

@Repository
public class StudentDaoImpl extends AbstractDao<Long, Student> implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	public void saveStudent(Student student) {

		logger.info("StudentDaoImpl->saveStudent()");
		persist(student);

	}

	@Override
	public List<Student> findAllUser() {
		System.out.println("StudentDAOImpl->findAllUser()");
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("studentFirstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Student> users = (List<Student>) criteria.list();
		List<Student> listofuser = new ArrayList<Student>();
		Fee f = new Fee();

		for (Student st : users) {
			List<String> inst = st.getFee().getNoOfInstallments();
			List<Date> date = st.getFee().getDuedate();
			f.setNoOfInstallments(inst);
			f.setDuedate(date);
			Student stu = new Student(st.getStudentId(), st.getAdmisstionNubmer(), st.getStudentFirstName(),
					st.getStudentLastName(), st.getFatherFirstName(), st.getFatherLastName(), st.getMotherFirstName(),
					st.getMotherLastName(), st.getDateOfBirth(), st.getGender(), st.getGrade(), st.getSection(),
					st.getAcademicYear(), st.getStudentAddress());
			stu.setFee(f);
			// st.setFee().getNoOfInstallments();
			System.out.println(stu);
			System.out.println(stu.getFee());
			System.out.println(stu.getFee().getDuedate());
			System.out.println(stu.getFee().getNoOfInstallments());
			listofuser.add(st);
		}
		// return (List<Student>)criteria.list();
		return listofuser;
	}

	public List<Student> findUser(int start, int total) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("studentFirstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFirstResult(start);
		criteria.setMaxResults(total);
		List<Student> listOfStudent = (List<Student>) criteria.list();
		List<Student> listofuser = new ArrayList<Student>();
		Fee f = new Fee();

		for (Student st : listOfStudent) {
			List<String> inst = st.getFee().getNoOfInstallments();
			List<Date> date = st.getFee().getDuedate();
			f.setNoOfInstallments(inst);
			f.setDuedate(date);
			Student stu = new Student(st.getStudentId(), st.getAdmisstionNubmer(), st.getStudentFirstName(),
					st.getStudentLastName(), st.getFatherFirstName(), st.getFatherLastName(), st.getMotherFirstName(),
					st.getMotherLastName(), st.getDateOfBirth(), st.getGender(), st.getGrade(), st.getSection(),
					st.getAcademicYear(), st.getStudentAddress());
			stu.setFee(f);
			// st.setFee().getNoOfInstallments();
			System.out.println(stu);
			System.out.println(stu.getFee());
			System.out.println(stu.getFee().getDuedate());
			System.out.println(stu.getFee().getNoOfInstallments());
			listofuser.add(st);
		}

		return listofuser;

	}

	/*
	 * @Override public Map<String,Double> feePaymntDetails(Student st) {
	 * System.out.println("StudentDAOIMPL->"+st); Criteria
	 * criteria=createEntityCriteria(); //
	 * criteria.add(Restrictions.eq("studentId",st.getStudentId()));
	 * criteria.add(Restrictions.eq("grade", st.getGrade()));
	 * criteria.add(Restrictions.eq("section",st.getSection()));
	 * criteria.add(Restrictions.eq("academicYear",st.getAcademicYear()));
	 * List<Student> listofStudent=criteria.list(); Double
	 * feecollected=0.0,duefee=0.0;
	 * 
	 * if(listofStudent!=null){
	 * 
	 * for(Student stud: listofStudent){ duefee=stud.getFee().getFeeBal();
	 * System.out.println("duefee"+duefee); } for(Student stud:listofStudent){
	 * feecollected=stud.getFee().getFeePaid()+feecollected;
	 * duefee=stud.getFee().getFeeBal()+duefee;
	 * System.out.println("StudentDAOIMPL->not Null"+stud); }
	 * 
	 * } Map<String,Double> m=new HashMap<String,Double>(); m.put("feeBal",
	 * duefee); m.put("feePaid", feecollected); return m; }
	 */

	@Override
	public List<Student> feePaymntDetails(Student st) {
		List<Student> li = new ArrayList<Student>();
		System.out.println("StudentDAOIMPL->" + st);
		Criteria criteria = createEntityCriteria();
		// criteria.add(Restrictions.eq("studentId",st.getStudentId()));
		criteria.add(Restrictions.eq("grade", st.getGrade()));
		criteria.add(Restrictions.eq("section", st.getSection()));
		criteria.add(Restrictions.eq("academicYear", st.getAcademicYear()));
		List<Student> listofStudent = criteria.list();
		Double feecollected = 0.0, duefee = 0.0;
		List<Student> list = new ArrayList<Student>();
		Fee f = new Fee();
		if (listofStudent != null) {

			for (Student stud : listofStudent) {

				// stu.setFee(fee);
				List<String> install = stud.getFee().getNoOfInstallments();
				List<Date> date = stud.getFee().getDuedate();
				Student stu = new Student(stud.getStudentId(), stud.getAdmisstionNubmer(), stud.getStudentFirstName(),
						stud.getStudentLastName(), stud.getFatherFirstName(), stud.getFatherLastName(),
						stud.getMotherFirstName(), stud.getMotherLastName(), stud.getDateOfBirth(), stud.getGender(),
						stud.getGrade(), stud.getSection(), stud.getAcademicYear(), stud.getStudentAddress());
				Fee fee = new Fee(stud.getFee().getFeeId(), stud.getFee().getTotalFeeAmount(),
						stud.getFee().getFeePaid(), stud.getFee().getFeeBal(), stud.getFee().getFeePayDate(), install,
						date);
				stu.setFee(fee);
				li.add(stu);
				/*
				 * f.setNoOfInstallments(install); f.setDuedate(date);
				 */

				// stu.setFee(f);
				/*
				 * if(stud.getFee().getFeeBal()!=0){ //
				 * System.out.println("StudentDAOIMPL->"+stud); li.add(stu); }
				 * duefee=stud.getFee().getFeeBal();
				 * System.out.println("duefee"+duefee);
				 */
			}
			/*
			 * for(Student stud:listofStudent){
			 * feecollected=stud.getFee().getFeePaid()+feecollected;
			 * duefee=stud.getFee().getFeeBal()+duefee;
			 * System.out.println("StudentDAOIMPL->not Null"+stud); }
			 */

		}
		System.out.println(li);
		return li;
	}

	public Student findStudentById(Long id) {
		System.out.println("StudentDaoImpl->findStudentById(id)");
		Set<Marks> setMarks=new HashSet<>();
		 Student student=null;
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("studentId",id));
		List<Student> listOfStudent=criteria.list();
		List<Student> li=new ArrayList<Student>();
		 if(listOfStudent!=null){
			 for(Student st:listOfStudent){
				 List<String> listofinst=st.getFee().getNoOfInstallments();
				 System.out.println(listofinst);
				 
				 List<Date> listofdate=st.getFee().getDuedate();
				 System.out.println(listofdate);
				   student=new Student(st.getStudentId(),st.getAdmisstionNubmer(),st.getStudentFirstName(),st.getStudentLastName(),st.getStudentFirstName(),st.getStudentLastName(),st.getMotherFirstName(),st.getMotherLastName(),st.getDateOfBirth(),st.getGender(),st.getGrade(),st.getSection(),st.getAcademicYear(),st.getStudentAddress());
				 Fee f=new Fee(st.getFee().getFeeId(),st.getFee().getTotalFeeAmount(),st.getFee().getFeePaid(),st.getFee().getFeeBal(),st.getFee().getFeePayDate(),listofinst,listofdate);
				 
				   Set<Marks> mrks=( Set<Marks>)st.getMarks();
				  for(Marks mrk:mrks){
					  Marks marks1=new Marks(mrk.getMarksid(),mrk.getSubjectname1(),mrk.getSubjectname2(),mrk.getSubjectname3(),mrk.getSubjectname4(),mrk.getSubjectname5(),mrk.getSubjectname6(),mrk.getSubjectname7(),mrk.getMarks1(),mrk.getMarks2(),mrk.getMarks3(),mrk.getMarks4(),mrk.getMarks5(),mrk.getMarks6(),mrk.getMarks7(),mrk.getInternalsname());
					  setMarks.add(marks1);
					  
				  }
				  
				  System.out.println(setMarks);
				  student.setMarks(setMarks); 
				 
				 
				/* Set<Marks> marks=st.getMarks(); 
				 Iterator it=marks.iterator();
				 
				 */
				 /*while(it.hasNext()){
					 Marks mrk=(Marks)it.next();
					 Marks marks1=new Marks(mrk.getMarksid(),mrk.getSubjectname1(),mrk.getSubjectname2(),mrk.getSubjectname3(),mrk.getSubjectname4(),mrk.getSubjectname5(),mrk.getSubjectname6(),mrk.getSubjectname7(),mrk.getMarks1(),mrk.getMarks2(),mrk.getMarks3(),mrk.getMarks4(),mrk.getMarks5(),mrk.getMarks6(),mrk.getMarks7(),mrk.getInternalsname());
					 marks1.setStudent(student);
					 //student.setMarks(marks);
				 }*/
				 
				 
				 
				 
student.setFee(f);				 
			 }
		 }
		 return student;

	}

	@Override
	public Student findById(Long id) {

		return getByKey(id);
	}

	
	public void saveStudentMarks(Marks mr){
		System.out.println("StudentDaoImpl->saveStudentMarks(st)"+mr);
		
		/*Set<Marks> setmarks=st.getMarks();
		
		*/
		
			
		
		 Student s=findById(mr.getStudent().getStudentId());
		 
		 Marks marks=new Marks(mr.getSubjectname1(), mr.getSubjectname2(),mr.getSubjectname3(),mr.getSubjectname4(),mr.getSubjectname5(),mr.getSubjectname6(),mr.getSubjectname7(),mr.getMarks1(),mr.getMarks2(), mr.getMarks3(),mr.getMarks4(),mr.getMarks5(), mr.getMarks6(),mr.getMarks7(),mr.getInternalsname());
		 
		 getSession().persist(marks);
		 
		  marks.setStudent(s);
		  
		  
		  
		  
		  Set<Marks> setMarks=new HashSet<Marks>();
		  setMarks.add(marks);
		  
		  s.setMarks(setMarks);
		  
		  
		  
		 
		 /* Fee f=new Fee(s.getFee().getFeeId(),s.getFee().getTotalFeeAmount(),s.getFee().getFeePaid(),s.getFee().getFeeBal(),s.getFee().getFeePayDate(),s.getFee().getNoOfInstallments(),s.getFee().getDuedate());
		 
		 
		 List<String> inst = s.getFee().getNoOfInstallments();
			List<Date> date = s.getFee().getDuedate();
			f.setNoOfInstallments(inst);
			f.setDuedate(date);
			
			 
			s.setFee(f);
			 */
		 
		/* for(Marks m:setmarks){
				
			}
		 
		
		 */
			
			//Marks mm=new Marks(st.getMarks().getSubjectname1(), st.getMarks().getSubjectname2(),st.getMarks().getSubjectname3(),st.getMarks().getSubjectname4(), st.getMarks().getSubjectname5(),st.getMarks().getSubjectname6(),st.getMarks().getSubjectname7(),st.getMarks().getMarks1(),st.getMarks().getMarks2(), st.getMarks().getMarks3(),st.getMarks().getMarks4(),st.getMarks().getMarks5(), st.getMarks().getMarks6(),st.getMarks().getMarks7(),st.getMarks().getInternalsname());
		 
		 //getSession().persist(mm);
			 
		  
			
		 //persist(s);
			//saveorUpdate(s);
			
			
			
			/* Set<Student> set=new HashSet<>();
			 set.add(s);
			 mm.setStudent(set);*/
			 
			// s.setMarks(mm);
			
			
		
			
		 System.out.println("-----------------------------------------------------------------------");
		 
		 System.out.println(s);
		 System.out.println("-----------------------------------------------------------------------");
		 
		  
		  //saveorUpdate(s);  
		    
		System.out.println("************************************************************");
		
		 
	}
	
	
	
	@Override
	public List<Student> selectStudOnCriter(Student stu) {
	 System.out.println("StudentDaoImpl->selectStudOnCriter(st)");
	 Student student=null;
	 String grade=stu.getGrade();
	  String year=stu.getAcademicYear();
	  String section=stu.getSection();
	  Criteria criteria=createEntityCriteria();
	  criteria.add(Restrictions.eq("grade", grade));
	  criteria.add(Restrictions.eq("section", section));
	  criteria.add(Restrictions.eq("academicYear", year));
	  List<Student> listOfStudent=criteria.list();
	  System.out.println("**********************************************************************");
	 /* System.out.println(listOfStudent);*/
	  System.out.println("**********************************************************************");
	  List<Student> li=new ArrayList<Student>();
		 if(listOfStudent!=null){
			 for(Student st:listOfStudent){
				 List<String> listofinst=st.getFee().getNoOfInstallments();
				 System.out.println(listofinst);
				 
				 List<Date> listofdate=st.getFee().getDuedate();
				 System.out.println(listofdate);
				   student=new Student(st.getStudentId(),st.getAdmisstionNubmer(),st.getStudentFirstName(),st.getStudentLastName(),st.getStudentFirstName(),st.getStudentLastName(),st.getMotherFirstName(),st.getMotherLastName(),st.getDateOfBirth(),st.getGender(),st.getGrade(),st.getSection(),st.getAcademicYear(),st.getStudentAddress());
				 Fee f=new Fee(st.getFee().getFeeId(),st.getFee().getTotalFeeAmount(),st.getFee().getFeePaid(),st.getFee().getFeeBal(),st.getFee().getFeePayDate(),listofinst,listofdate);
student.setFee(f);		
li.add(student);
			 }
		 }
		 return li;
	  
		 
	}
}
