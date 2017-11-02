package com.nr.springmvc.student.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nr.springmvc.model.Marks;
import com.nr.springmvc.model.Student;
import com.nr.springmvc.student.dao.StudentDAO;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDAO studentDao;
	
	@Override
	public void saveStudent(Student student) {
		 
		studentDao.saveStudent(student);
	}
	
	
	public List<Student> findAllUser(){
	return studentDao.findAllUser();
	}

	
	public List<Student> findUser(int start,int total){
		return studentDao.findUser(start, total);
	}
	
	
	public List<Student> feePaymntDetails(Student st){
		return studentDao.feePaymntDetails(st);
	}
	public Student findStudentById(Long id){
		return studentDao.findStudentById(id);
	}

	@Override
	public Student finById(Long id) {
		 
		return studentDao.findById(id);
	}


	@Override
	public void saveStudentMarks(Marks mr) {
	 
		  studentDao.saveStudentMarks(mr);
	}
	
	@Override
	public List<Student> selectStudOnCriter(Student st) {
		 
		return studentDao.selectStudOnCriter(st);
	}


	 
	
	
	/*@Override
	public Double totalFee(Student st) {
		 
		return studentDao.totalFee(st);
	}
	
	
	public Double totalDue(Student st){
		return studentDao.totalDue(st);
	}
	*/
	
	/*public Map<String,Double> feePaymntDetails(Student st){
		return studentDao.feePaymntDetails(st);
	}*/
}
