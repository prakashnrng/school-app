package com.nr.springmvc.student.service;

import java.util.List;
import java.util.Map;

import com.nr.springmvc.model.Marks;
import com.nr.springmvc.model.Student;

public interface StudentService {

	public void saveStudent(Student student);
	
	public List<Student> findAllUser();
	
	public List<Student> findUser(int start,int total);
	
	/*public Double totalFee(Student st);
	
	public Double totalDue(Student st);
	*/
	//public Map<String,Double> feePaymntDetails(Student st);
	public List<Student> feePaymntDetails(Student st);
	
	public Student findStudentById(Long studentId);
	
	public Student finById(Long id);
	
	public void saveStudentMarks(Marks mr);
	
	
	public List<Student> selectStudOnCriter(Student st);
}
