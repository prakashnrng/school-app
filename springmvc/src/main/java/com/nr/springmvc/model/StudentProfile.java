package com.nr.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class StudentProfile implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TYPE",length=15,unique=true,nullable=false)
	private String type=UserProfileType.USER.getUserProfileType();
	
	
	
}
