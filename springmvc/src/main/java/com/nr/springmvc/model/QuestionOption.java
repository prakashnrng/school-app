package com.nr.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="questionoption")
public class QuestionOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="qoptionid")
	Long qoptionid;
	
	
	@Column(name="qoption1")
	String qoption1;
	
	
	@Column(name="qoption2")
	String qoption2;
	
	@Column(name="qoption3")
	String qoption3;
	
	@Column(name="qoption4")
	String qoption4;
	
	
	@OneToOne
	@JoinColumn(name="qoptionid")
	Question quest;
	
	public QuestionOption() {
		 
	}

	public QuestionOption(Long qoptionid, String qoption1, String qoption2, String qoption3, String qoption4) {
		super();
		this.qoptionid = qoptionid;
		this.qoption1 = qoption1;
		this.qoption2 = qoption2;
		this.qoption3 = qoption3;
		this.qoption4 = qoption4;
		 
	}

	
	
	
	
	public QuestionOption(String qoption1, String qoption2, String qoption3, String qoption4) {
		super();
		this.qoption1 = qoption1;
		this.qoption2 = qoption2;
		this.qoption3 = qoption3;
		this.qoption4 = qoption4;
	}

	public Long getQoptionid() {
		return qoptionid;
	}

	public void setQoptionid(Long qoptionid) {
		this.qoptionid = qoptionid;
	}

	public String getQoption1() {
		return qoption1;
	}

	public void setQoption1(String qoption1) {
		this.qoption1 = qoption1;
	}

	public String getQoption2() {
		return qoption2;
	}

	public void setQoption2(String qoption2) {
		this.qoption2 = qoption2;
	}

	public String getQoption3() {
		return qoption3;
	}

	public void setQoption3(String qoption3) {
		this.qoption3 = qoption3;
	}

	public String getQoption4() {
		return qoption4;
	}

	public void setQoption4(String qoption4) {
		this.qoption4 = qoption4;
	}

	public Question getQuest() {
		return quest;
	}

	public void setQuest(Question quest) {
		this.quest = quest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qoption1 == null) ? 0 : qoption1.hashCode());
		result = prime * result + ((qoption2 == null) ? 0 : qoption2.hashCode());
		result = prime * result + ((qoption3 == null) ? 0 : qoption3.hashCode());
		result = prime * result + ((qoption4 == null) ? 0 : qoption4.hashCode());
		result = prime * result + ((qoptionid == null) ? 0 : qoptionid.hashCode());
		result = prime * result + ((quest == null) ? 0 : quest.hashCode());
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
		QuestionOption other = (QuestionOption) obj;
		if (qoption1 == null) {
			if (other.qoption1 != null)
				return false;
		} else if (!qoption1.equals(other.qoption1))
			return false;
		if (qoption2 == null) {
			if (other.qoption2 != null)
				return false;
		} else if (!qoption2.equals(other.qoption2))
			return false;
		if (qoption3 == null) {
			if (other.qoption3 != null)
				return false;
		} else if (!qoption3.equals(other.qoption3))
			return false;
		if (qoption4 == null) {
			if (other.qoption4 != null)
				return false;
		} else if (!qoption4.equals(other.qoption4))
			return false;
		if (qoptionid == null) {
			if (other.qoptionid != null)
				return false;
		} else if (!qoptionid.equals(other.qoptionid))
			return false;
		if (quest == null) {
			if (other.quest != null)
				return false;
		} else if (!quest.equals(other.quest))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionOption [qoptionid=" + qoptionid + ", qoption1=" + qoption1 + ", qoption2=" + qoption2
				+ ", qoption3=" + qoption3 + ", qoption4=" + qoption4 +  "]";
	}

	 
	
	
	

}
