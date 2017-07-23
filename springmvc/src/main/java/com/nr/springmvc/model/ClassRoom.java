package com.nr.springmvc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

 

@Entity
@Table(name="classRoom")
public class ClassRoom {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long classRoomId;
	
	private String classes;
	private String section;
	private Date academicYear;
	private String totalNumberOfStudent;
	//private Fee fee;
	
	public ClassRoom() {
		 System.out.println("ClassRoom->D.c");
	}
	
	
	
	
	public ClassRoom(Long classRoomId, String classes, String section, Date academicYear, String totalNumberOfStudent) {
		super();
		this.classRoomId = classRoomId;
		this.classes = classes;
		this.section = section;
		this.academicYear = academicYear;
		this.totalNumberOfStudent = totalNumberOfStudent;
		//this.fee = fee;
	}




	public Long getClassRoomId() {
		return classRoomId;
	}
	public void setClassRoomId(Long classRoomId) {
		this.classRoomId = classRoomId;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Date getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(Date academicYear) {
		this.academicYear = academicYear;
	}
	public String getTotalNumberOfStudent() {
		return totalNumberOfStudent;
	}
	public void setTotalNumberOfStudent(String totalNumberOfStudent) {
		this.totalNumberOfStudent = totalNumberOfStudent;
	}
	 
	
	
	
}
