package com.nr.springmvc.student.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nr.springmvc.dao.AbstractDao;
import com.nr.springmvc.model.Fee;
import com.nr.springmvc.model.Student;
import com.nr.springmvc.model.User;

@Repository
public class StudentDaoImpl extends AbstractDao<Long, Student> implements StudentDAO {

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
		return li;
	}

	public Student findStudentById(Long id) {
		System.out.println("StudentDaoImpl->findStudentById(id)");
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
student.setFee(f);				 
			 }
		 }
		 return student;

	}

	@Override
	public Student findById(Long id) {

		return getByKey(id);
	}

}
