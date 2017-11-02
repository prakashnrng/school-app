package com.nr.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="qrightoption")
public class QuestionRightOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="qrightoptionid")
	Long qrightoptionid;
	
	@Column(name="qroption1")
	String qroption1;
	
	
	@Column(name="qroption2")
	String qroption2;
	
	@Column(name="qroption3")
	String qroption3;
	
	@Column(name="qroption4")
	String qroption4;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="qrightoptionid")
	Question quest;


	public Long getQrightoptionid() {
		return qrightoptionid;
	}

	
	public QuestionRightOption() {
		 
	}
	

	public QuestionRightOption(Long qrightoptionid, String qroption1, String qroption2, String qroption3,
			String qroption4) {
		super();
		this.qrightoptionid = qrightoptionid;
		this.qroption1 = qroption1;
		this.qroption2 = qroption2;
		this.qroption3 = qroption3;
		this.qroption4 = qroption4;
	 
	}





	public QuestionRightOption(String qroption1, String qroption2, String qroption3, String qroption4) {
		super();
		this.qroption1 = qroption1;
		this.qroption2 = qroption2;
		this.qroption3 = qroption3;
		this.qroption4 = qroption4;
		
	}





	public void setQrightoptionid(Long qrightoptionid) {
		this.qrightoptionid = qrightoptionid;
	}


	public String getQroption1() {
		return qroption1;
	}


	public void setQroption1(String qroption1) {
		this.qroption1 = qroption1;
	}


	public String getQroption2() {
		return qroption2;
	}


	public void setQroption2(String qroption2) {
		this.qroption2 = qroption2;
	}


	public String getQroption3() {
		return qroption3;
	}


	public void setQroption3(String qroption3) {
		this.qroption3 = qroption3;
	}


	public String getQroption4() {
		return qroption4;
	}


	public void setQroption4(String qroption4) {
		this.qroption4 = qroption4;
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
		result = prime * result + ((qrightoptionid == null) ? 0 : qrightoptionid.hashCode());
		result = prime * result + ((qroption1 == null) ? 0 : qroption1.hashCode());
		result = prime * result + ((qroption2 == null) ? 0 : qroption2.hashCode());
		result = prime * result + ((qroption3 == null) ? 0 : qroption3.hashCode());
		result = prime * result + ((qroption4 == null) ? 0 : qroption4.hashCode());
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
		QuestionRightOption other = (QuestionRightOption) obj;
		if (qrightoptionid == null) {
			if (other.qrightoptionid != null)
				return false;
		} else if (!qrightoptionid.equals(other.qrightoptionid))
			return false;
		if (qroption1 == null) {
			if (other.qroption1 != null)
				return false;
		} else if (!qroption1.equals(other.qroption1))
			return false;
		if (qroption2 == null) {
			if (other.qroption2 != null)
				return false;
		} else if (!qroption2.equals(other.qroption2))
			return false;
		if (qroption3 == null) {
			if (other.qroption3 != null)
				return false;
		} else if (!qroption3.equals(other.qroption3))
			return false;
		if (qroption4 == null) {
			if (other.qroption4 != null)
				return false;
		} else if (!qroption4.equals(other.qroption4))
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
		return "QuestionRightOption [qrightoptionid=" + qrightoptionid + ", qroption1=" + qroption1 + ", qroption2="
				+ qroption2 + ", qroption3=" + qroption3 + ", qroption4=" + qroption4 +"]";
	}
	
	
	
	
	
	
	

}
