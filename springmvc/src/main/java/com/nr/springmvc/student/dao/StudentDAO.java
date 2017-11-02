package com.nr.springmvc.student.dao;

import java.util.List;
import java.util.Map;

import com.nr.springmvc.model.Marks;
import com.nr.springmvc.model.Student;

public interface StudentDAO {

	void saveStudent(Student stud);
	
	public List<Student> findAllUser();
	public List<Student> findUser(int start,int total);
	//public Double totalFee(Student st);
	//public Map<String,Double> feePaymntDetails(Student st);
	public List<Student> feePaymntDetails(Student st);
public Student findStudentById(Long id);
	public Student findById(Long id);
	public void saveStudentMarks(Marks mr);
	
	public List<Student> selectStudOnCriter(Student st);
}
