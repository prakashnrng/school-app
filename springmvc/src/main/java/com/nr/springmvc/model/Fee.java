package com.nr.springmvc.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "schoo_fee")
public class Fee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feeid", nullable = false)
	Long feeId;

	 
	@Column(name = "totalfeeamount", nullable = false)
	private double totalFeeAmount;

	 
	@Column(name = "feepaid", nullable = false)
	private double feePaid;

	 
	@Column(name = "feebal", nullable = false)
	private double feeBal;

	@NotEmpty
	@Column(name = "feepaydate")
	private String feePayDate;

	
	/*
	 * @OneToMany
		@JoinTable(name="Installment",
		joinColumns={@JoinColumn(name="feeid")})
	 */
	
	
	/*@NotEmpty
	@OneToMany
	@JoinTable(name="installment",joinColumns=@JoinColumn(name="feeid"))
	@OrderColumn(name="idx")
	@Column(name = "noofinstallments")
	private String[] noOfInstallments;*/
  
	@ElementCollection
	@CollectionTable(name="noofinstallments",joinColumns=@JoinColumn(name="feeid"))
 	@Column(name = "noofinstallments")
	private List<String> noOfInstallments;
	
	
	
	/*
	 * @OneToMany
	@JoinTable(name="DUEDATE",
	joinColumns={@JoinColumn(name="feeid")})
	 
	 */
	
 
	@ElementCollection
	@CollectionTable(name="duedate",joinColumns=@JoinColumn(name="feeid"))
	@Column(name="duedate")
	private List<Date> duedate;
	
		 
	
	@OneToOne
	@JoinColumn(name = "feeid")
	private Student student;

	/* private String[] installmentDate; */

	public Fee() {
		System.out.println("Fee->D.C");
	}
	
	
	

	 




	public Fee(Long feeId, double totalFeeAmount, double feePaid, double feeBal, String feePayDate,
			List<String> noOfInstallments, List<Date> duedate) {
		super();
		this.feeId = feeId;
		this.totalFeeAmount = totalFeeAmount;
		this.feePaid = feePaid;
		this.feeBal = feeBal;
		this.feePayDate = feePayDate;
		this.noOfInstallments = noOfInstallments;
		this.duedate = duedate;
	}









	public Fee(double totalFeeAmount, double feePaid, double feeBal, String feePayDate, List<String> noOfInstallments,
			List<Date> duedate) {
		super();
		this.totalFeeAmount = totalFeeAmount;
		this.feePaid = feePaid;
		this.feeBal = feeBal;
		this.feePayDate = feePayDate;
		this.noOfInstallments = noOfInstallments;
		this.duedate = duedate;
	}









	public Long getFeeId() {
		return feeId;
	}

	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}

	public double getTotalFeeAmount() {
		return totalFeeAmount;
	}

	public void setTotalFeeAmount(double totalFeeAmount) {
		this.totalFeeAmount = totalFeeAmount;
	}

	public double getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(double feePaid) {
		this.feePaid = feePaid;
	}

	public double getFeeBal() {
		return feeBal;
	}

	public void setFeeBal(double feeBal) {
		this.feeBal = feeBal;
	}

	public String getFeePayDate() {
		return feePayDate;
	}

	public void setFeePayDate(String feePayDate) {
		this.feePayDate = feePayDate;
	}
 

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}





	public List<String> getNoOfInstallments() {
		return noOfInstallments;
	}





	public void setNoOfInstallments(List<String> noOfInstallments) {
		this.noOfInstallments = noOfInstallments;
	}









	public List<Date> getDuedate() {
		return duedate;
	}









	public void setDuedate(List<Date> duedate) {
		this.duedate = duedate;
	}









	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(feeBal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((feeId == null) ? 0 : feeId.hashCode());
		temp = Double.doubleToLongBits(feePaid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((feePayDate == null) ? 0 : feePayDate.hashCode());
		result = prime * result + ((noOfInstallments == null) ? 0 : noOfInstallments.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		temp = Double.doubleToLongBits(totalFeeAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Fee other = (Fee) obj;
		if (duedate == null) {
			if (other.duedate != null)
				return false;
		} else if (!duedate.equals(other.duedate))
			return false;
		if (Double.doubleToLongBits(feeBal) != Double.doubleToLongBits(other.feeBal))
			return false;
		if (feeId == null) {
			if (other.feeId != null)
				return false;
		} else if (!feeId.equals(other.feeId))
			return false;
		if (Double.doubleToLongBits(feePaid) != Double.doubleToLongBits(other.feePaid))
			return false;
		if (feePayDate == null) {
			if (other.feePayDate != null)
				return false;
		} else if (!feePayDate.equals(other.feePayDate))
			return false;
		if (noOfInstallments == null) {
			if (other.noOfInstallments != null)
				return false;
		} else if (!noOfInstallments.equals(other.noOfInstallments))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (Double.doubleToLongBits(totalFeeAmount) != Double.doubleToLongBits(other.totalFeeAmount))
			return false;
		return true;
	}









	@Override
	public String toString() {
		return "Fee [feeId=" + feeId + ", totalFeeAmount=" + totalFeeAmount + ", feePaid=" + feePaid + ", feeBal="
				+ feeBal + ", feePayDate=" + feePayDate + ", noOfInstallments=" + noOfInstallments + ", duedate="
				+ duedate + "]";
	}









	 









	 






 



 

	 

	 

 
	 

	 
	
}
