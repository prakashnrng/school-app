package com.nr.springmvc.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="studentmarks")
public class Marks {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="marksid")
	private long marksid;
	
	
	@Column(name="subjectname1")
	private String subjectname1;
	
	@Column(name="subjectname2")
	private String subjectname2;
	
	@Column(name="subjectname3")
	private String subjectname3;
	
	@Column(name="subjectname4")
	private String subjectname4;
	
	@Column(name="subjectname5")
	private String subjectname5;
	
	@Column(name="subjectname6")
	private String subjectname6;
	
	@Column(name="subjectname7")
	private String subjectname7;
	
	
	@Column(name="marks1")
	private float marks1;
	
	@Column(name="marks2")
	private float marks2;
	
	@Column(name="marks3")
	private float marks3;
	
	@Column(name="marks4")
	private float marks4;
	
	@Column(name="marks5")
	private float marks5;
	
	@Column(name="marks6")
	private float marks6;
	
	@Column(name="marks7")
	private float marks7;
	
	
	@Column(name="internalsname")
	private String internalsname;
	
	

	
	
	
	 @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentid",referencedColumnName="studentid") 
	 Student student;
	 
	
	
	public Marks() {
		 
	}


	 		public Marks(long marksid, String subjectname1, String subjectname2, String subjectname3, String subjectname4,
			String subjectname5, String subjectname6, String subjectname7, float marks1, float marks2, float marks3,
			float marks4, float marks5, float marks6, float marks7, String internalsname) {
		super();
		this.marksid = marksid;
		this.subjectname1 = subjectname1;
		this.subjectname2 = subjectname2;
		this.subjectname3 = subjectname3;
		this.subjectname4 = subjectname4;
		this.subjectname5 = subjectname5;
		this.subjectname6 = subjectname6;
		this.subjectname7 = subjectname7;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.marks4 = marks4;
		this.marks5 = marks5;
		this.marks6 = marks6;
		this.marks7 = marks7;
		this.internalsname = internalsname;
	}



	public Marks(String subjectname1, String subjectname2, String subjectname3, String subjectname4,
					String subjectname5, String subjectname6, String subjectname7, float marks1, float marks2,
					float marks3, float marks4, float marks5, float marks6, float marks7, String internalsname) {
				super();
				this.subjectname1 = subjectname1;
				this.subjectname2 = subjectname2;
				this.subjectname3 = subjectname3;
				this.subjectname4 = subjectname4;
				this.subjectname5 = subjectname5;
				this.subjectname6 = subjectname6;
				this.subjectname7 = subjectname7;
				this.marks1 = marks1;
				this.marks2 = marks2;
				this.marks3 = marks3;
				this.marks4 = marks4;
				this.marks5 = marks5;
				this.marks6 = marks6;
				this.marks7 = marks7;
				this.internalsname = internalsname;
			}


	 
	 


	 


	public long getMarksid() {
		return marksid;
	}


	public void setMarksid(long marksid) {
		this.marksid = marksid;
	}


	public String getSubjectname1() {
		return subjectname1;
	}


	public void setSubjectname1(String subjectname1) {
		this.subjectname1 = subjectname1;
	}


	public String getSubjectname2() {
		return subjectname2;
	}


	public void setSubjectname2(String subjectname2) {
		this.subjectname2 = subjectname2;
	}


	public String getSubjectname3() {
		return subjectname3;
	}


	public void setSubjectname3(String subjectname3) {
		this.subjectname3 = subjectname3;
	}


	public String getSubjectname4() {
		return subjectname4;
	}


	public void setSubjectname4(String subjectname4) {
		this.subjectname4 = subjectname4;
	}


	public String getSubjectname5() {
		return subjectname5;
	}


	public void setSubjectname5(String subjectname5) {
		this.subjectname5 = subjectname5;
	}


	public String getSubjectname6() {
		return subjectname6;
	}


	public void setSubjectname6(String subjectname6) {
		this.subjectname6 = subjectname6;
	}


	public String getSubjectname7() {
		return subjectname7;
	}


	public void setSubjectname7(String subjectname7) {
		this.subjectname7 = subjectname7;
	}


	public float getMarks1() {
		return marks1;
	}


	public void setMarks1(float marks1) {
		this.marks1 = marks1;
	}


	public float getMarks2() {
		return marks2;
	}


	public void setMarks2(float marks2) {
		this.marks2 = marks2;
	}


	public float getMarks3() {
		return marks3;
	}


	public void setMarks3(float marks3) {
		this.marks3 = marks3;
	}


	public float getMarks4() {
		return marks4;
	}


	public void setMarks4(float marks4) {
		this.marks4 = marks4;
	}


	public float getMarks5() {
		return marks5;
	}


	public void setMarks5(float marks5) {
		this.marks5 = marks5;
	}


	public float getMarks6() {
		return marks6;
	}


	public void setMarks6(float marks6) {
		this.marks6 = marks6;
	}


	public float getMarks7() {
		return marks7;
	}


	public void setMarks7(float marks7) {
		this.marks7 = marks7;
	}


	 

	public String getInternalsname() {
		return internalsname;
	}

	public void setInternalsname(String internalsname) {
		this.internalsname = internalsname;
	}

	
	
	
	
	

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Marks(long marksid, String subjectname1, String subjectname2, String subjectname3, String subjectname4,
			String subjectname5, String subjectname6, String subjectname7, float marks1, float marks2, float marks3,
			float marks4, float marks5, float marks6, float marks7, String internalsname, Student student) {
		super();
		this.marksid = marksid;
		this.subjectname1 = subjectname1;
		this.subjectname2 = subjectname2;
		this.subjectname3 = subjectname3;
		this.subjectname4 = subjectname4;
		this.subjectname5 = subjectname5;
		this.subjectname6 = subjectname6;
		this.subjectname7 = subjectname7;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.marks4 = marks4;
		this.marks5 = marks5;
		this.marks6 = marks6;
		this.marks7 = marks7;
		this.internalsname = internalsname;
		this.student = student;
	}


	@Override
	public String toString() {
		return "Marks [marksid=" + marksid + ", subjectname1=" + subjectname1 + ", subjectname2=" + subjectname2
				+ ", subjectname3=" + subjectname3 + ", subjectname4=" + subjectname4 + ", subjectname5=" + subjectname5
				+ ", subjectname6=" + subjectname6 + ", subjectname7=" + subjectname7 + ", marks1=" + marks1
				+ ", marks2=" + marks2 + ", marks3=" + marks3 + ", marks4=" + marks4 + ", marks5=" + marks5
				+ ", marks6=" + marks6 + ", marks7=" + marks7 + ", internalsname=" + internalsname + 
				  "]";
	}


	 
	 
	
	
	 






 
	
	
}
