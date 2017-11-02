package com.nr.springmvc.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

 @Entity
@Table(name = "addquestion") 
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qidnum")
	Long qidnum;
	
	
	
	@Column(name="chaptername")
	private String chaptername;
	
	
	@Column(name="subjectname")
	private String subjectname;
	

	@Column(name = "question",length=1000)
	String question;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "qrightoptionid")
	QuestionRightOption qrightoption;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "qoptionid")
	QuestionOption qoption;

	
	@ElementCollection
	@CollectionTable(name="enteredsolution",joinColumns=@JoinColumn(name="qidnum"))
	@IndexColumn(name="eidx")
	@Column(name="enteredsolution")
	private List<String> enteredsolution;
	
	
	
	
	
	
	/*@ElementCollection
	@CollectionTable(name="",joinColumns=@JoinColumn(name=""))
	@Column(name="")
	private List<String> */
	
	
	 
	
	

	 

	public Question() {

	}

	
	/*public Question(Long qidnum, String question, QuestionRightOption qrightoption, QuestionOption qoption) {
		super();
		this.qidnum = qidnum;
		this.question = question;
		this.qrightoption = qrightoption;
		this.qoption = qoption;

	}

	public Question(String question, QuestionRightOption qrightoption, QuestionOption qoption) {
		super();
		this.question = question;
		this.qrightoption = qrightoption;
		this.qoption = qoption;

	}*/
	
	
	public Question(Long qidnum, String chaptername, String subjectname, String question) {
		super();
		this.qidnum = qidnum;
		this.chaptername = chaptername;
		this.subjectname = subjectname;
		this.question = question;
		 
	}

	 

	 


	public Question(String chaptername, String subjectname, String question) {
		super();
		this.chaptername = chaptername;
		this.subjectname = subjectname;
		this.question = question;
		 
	}


	public Long getQidnum() {
		return qidnum;
	}

	


	public void setQidnum(Long qidnum) {
		this.qidnum = qidnum;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionRightOption getQrightoption() {
		return qrightoption;
	}

	public void setQrightoption(QuestionRightOption qrightoption) {
		this.qrightoption = qrightoption;
	}

	public QuestionOption getQoption() {
		return qoption;
	}

	public void setQoption(QuestionOption qoption) {
		this.qoption = qoption;
	}

	public List<String> getEnteredsolution() {
		return enteredsolution;
	}

	public void setEnteredsolution(List<String> enteredsolution) {
		this.enteredsolution = enteredsolution;
	}
	
	
	public String getChaptername() {
		return chaptername;
	}

	public void setChaptername(String chaptername) {
		this.chaptername = chaptername;
	}

	

	 
	public String getSubjectname() {
		return subjectname;
	}


	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	
	
	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chaptername == null) ? 0 : chaptername.hashCode());
		result = prime * result + ((enteredsolution == null) ? 0 : enteredsolution.hashCode());
		result = prime * result + ((qidnum == null) ? 0 : qidnum.hashCode());
		result = prime * result + ((qoption == null) ? 0 : qoption.hashCode());
		result = prime * result + ((qrightoption == null) ? 0 : qrightoption.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((subjectname == null) ? 0 : subjectname.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (chaptername == null) {
			if (other.chaptername != null)
				return false;
		} else if (!chaptername.equals(other.chaptername))
			return false;
		if (enteredsolution == null) {
			if (other.enteredsolution != null)
				return false;
		} else if (!enteredsolution.equals(other.enteredsolution))
			return false;
		if (qidnum == null) {
			if (other.qidnum != null)
				return false;
		} else if (!qidnum.equals(other.qidnum))
			return false;
		if (qoption == null) {
			if (other.qoption != null)
				return false;
		} else if (!qoption.equals(other.qoption))
			return false;
		if (qrightoption == null) {
			if (other.qrightoption != null)
				return false;
		} else if (!qrightoption.equals(other.qrightoption))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (subjectname == null) {
			if (other.subjectname != null)
				return false;
		} else if (!subjectname.equals(other.subjectname))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Question [qidnum=" + qidnum + ", chaptername=" + chaptername + ", subjectname=" + subjectname
				+ ", question=" + question + ", qrightoption=" + qrightoption + ", qoption=" + qoption
				+ ", enteredsolution=" + enteredsolution + "]";
	}


	/*@Override
	public String toString() {
		return "Question [qidnum=" + qidnum + ", question=" + question + ", qrightoption=" + qrightoption + ", qoption="
				+ qoption + ", enteredsolution=" + enteredsolution + "]";
	}*/
	
	 

	 
	
		 
	 

		 
	 

	 
 

	 
	 

}