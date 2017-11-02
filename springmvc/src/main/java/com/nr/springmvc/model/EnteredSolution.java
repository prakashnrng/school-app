package com.nr.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*@Entity
@Table(name="enteredSolution")*/
public class EnteredSolution {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="enteredsolutionid")
	Long enteredsolutionid;
	
	
	@Column(name="enteredsolution1")
	String enteredsolution1;
	
	
	@Column(name="enteredsolution2")
	String enteredsolution2;
	
	@Column(name="enteredsolution3")
	String enteredsolution3;
	
	@Column(name="enteredsolution4")
	String enteredsolution4;
	
	
	 /*@OneToOne
	 @JoinColumn(name="qoptionid")
	 Question question;
	 */
	
	 
	 public EnteredSolution() {
	 
	}



	public EnteredSolution(Long enteredsolutionid, String enteredsolution1, String enteredsolution2,
			String enteredsolution3, String enteredsolution4) {
		super();
		this.enteredsolutionid = enteredsolutionid;
		this.enteredsolution1 = enteredsolution1;
		this.enteredsolution2 = enteredsolution2;
		this.enteredsolution3 = enteredsolution3;
		this.enteredsolution4 = enteredsolution4;
		 
	}



	public EnteredSolution(String enteredsolution1, String enteredsolution2, String enteredsolution3,
			String enteredsolution4) {
		super();
		this.enteredsolution1 = enteredsolution1;
		this.enteredsolution2 = enteredsolution2;
		this.enteredsolution3 = enteredsolution3;
		this.enteredsolution4 = enteredsolution4;
	}



	public Long getEnteredsolutionid() {
		return enteredsolutionid;
	}



	public void setEnteredsolutionid(Long enteredsolutionid) {
		this.enteredsolutionid = enteredsolutionid;
	}



	public String getEnteredsolution1() {
		return enteredsolution1;
	}



	public void setEnteredsolution1(String enteredsolution1) {
		this.enteredsolution1 = enteredsolution1;
	}



	public String getEnteredsolution2() {
		return enteredsolution2;
	}



	public void setEnteredsolution2(String enteredsolution2) {
		this.enteredsolution2 = enteredsolution2;
	}



	public String getEnteredsolution3() {
		return enteredsolution3;
	}



	public void setEnteredsolution3(String enteredsolution3) {
		this.enteredsolution3 = enteredsolution3;
	}



	public String getEnteredsolution4() {
		return enteredsolution4;
	}



	public void setEnteredsolution4(String enteredsolution4) {
		this.enteredsolution4 = enteredsolution4;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enteredsolution1 == null) ? 0 : enteredsolution1.hashCode());
		result = prime * result + ((enteredsolution2 == null) ? 0 : enteredsolution2.hashCode());
		result = prime * result + ((enteredsolution3 == null) ? 0 : enteredsolution3.hashCode());
		result = prime * result + ((enteredsolution4 == null) ? 0 : enteredsolution4.hashCode());
		result = prime * result + ((enteredsolutionid == null) ? 0 : enteredsolutionid.hashCode());
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
		EnteredSolution other = (EnteredSolution) obj;
		if (enteredsolution1 == null) {
			if (other.enteredsolution1 != null)
				return false;
		} else if (!enteredsolution1.equals(other.enteredsolution1))
			return false;
		if (enteredsolution2 == null) {
			if (other.enteredsolution2 != null)
				return false;
		} else if (!enteredsolution2.equals(other.enteredsolution2))
			return false;
		if (enteredsolution3 == null) {
			if (other.enteredsolution3 != null)
				return false;
		} else if (!enteredsolution3.equals(other.enteredsolution3))
			return false;
		if (enteredsolution4 == null) {
			if (other.enteredsolution4 != null)
				return false;
		} else if (!enteredsolution4.equals(other.enteredsolution4))
			return false;
		if (enteredsolutionid == null) {
			if (other.enteredsolutionid != null)
				return false;
		} else if (!enteredsolutionid.equals(other.enteredsolutionid))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "EnteredSolution [enteredsolutionid=" + enteredsolutionid + ", enteredsolution1=" + enteredsolution1
				+ ", enteredsolution2=" + enteredsolution2 + ", enteredsolution3=" + enteredsolution3
				+ ", enteredsolution4=" + enteredsolution4 + "]";
	}



	/*public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}*/



	 

}
