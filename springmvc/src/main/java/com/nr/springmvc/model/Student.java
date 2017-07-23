package com.nr.springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentid", nullable = false)
	private Long studentId;

	@NotEmpty
	@Column(name = "admisstionnubmer", nullable = false)
	private String admisstionNubmer;

	@Size(min = 3, max = 30)
	@Column(name = "studentfirstname", nullable = false)
	private String studentFirstName;

	@Size(min = 6, max = 30)
	@Column(name = "studentlastname", nullable = false)
	private String studentLastName;

	@Size(min = 3, max = 30)
	@Column(name = "fatherfirstname", nullable = false)
	private String fatherFirstName;

	@Size(min = 6, max = 30)
	@Column(name = "fatherlastname", nullable = false)
	private String fatherLastName;

	@Size(min = 3, max = 30)
	@Column(name = "motherfirstname", nullable = false)
	private String motherFirstName;

	@Size(min = 6, max = 30)
	@Column(name = "motherlastname", nullable = false)
	private String motherLastName;

	 
	
	/*
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @Column(name = "dateofbirth")
	 * 
	 * @DateTimeFormat(pattern="mm/dd/yyyy") private Date dateOfBirth;
	 */

	@NotEmpty
	@Column(name = "dateofbirth", nullable = false)
	private String dateOfBirth;

	@NotEmpty
	@Column(name = "gender", nullable = false)
	private String gender;

	@NotEmpty
	@Column(name = "grade", nullable = false)
	private String grade;

	@NotEmpty
	@Column(name = "section", nullable = false)
	private String section;

	@NotEmpty
	@Column(name = "academicyear", nullable = false)
	private String academicYear;

	@NotEmpty
	@Column(name = "studentaddress", nullable = false)
	private String studentAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "feeid")
	Fee fee;

	public Student() {
		super();

	}

	public Student(Long studentId, String admisstionNubmer, String studentFirstName, String studentLastName,
			String fatherFirstName, String fatherLastName, String motherFirstName, String motherLastName,
			String dateOfBirth, String gender, String grade, String section, String academicYear,
			String studentAddress) {
		super();
		this.studentId = studentId;
		this.admisstionNubmer = admisstionNubmer;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.fatherFirstName = fatherFirstName;
		this.fatherLastName = fatherLastName;
		this.motherFirstName = motherFirstName;
		this.motherLastName = motherLastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.grade = grade;
		this.section = section;
		this.academicYear = academicYear;
		this.studentAddress = studentAddress;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getAdmisstionNubmer() {
		return admisstionNubmer;
	}

	public void setAdmisstionNubmer(String admisstionNubmer) {
		this.admisstionNubmer = admisstionNubmer;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getFatherFirstName() {
		return fatherFirstName;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getMotherFirstName() {
		return motherFirstName;
	}

	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academicYear == null) ? 0 : academicYear.hashCode());
		result = prime * result + ((admisstionNubmer == null) ? 0 : admisstionNubmer.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((fatherFirstName == null) ? 0 : fatherFirstName.hashCode());
		result = prime * result + ((fatherLastName == null) ? 0 : fatherLastName.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((motherFirstName == null) ? 0 : motherFirstName.hashCode());
		result = prime * result + ((motherLastName == null) ? 0 : motherLastName.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + ((studentAddress == null) ? 0 : studentAddress.hashCode());
		result = prime * result + ((studentFirstName == null) ? 0 : studentFirstName.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((studentLastName == null) ? 0 : studentLastName.hashCode());
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
		Student other = (Student) obj;
		if (academicYear == null) {
			if (other.academicYear != null)
				return false;
		} else if (!academicYear.equals(other.academicYear))
			return false;
		if (admisstionNubmer == null) {
			if (other.admisstionNubmer != null)
				return false;
		} else if (!admisstionNubmer.equals(other.admisstionNubmer))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (fatherFirstName == null) {
			if (other.fatherFirstName != null)
				return false;
		} else if (!fatherFirstName.equals(other.fatherFirstName))
			return false;
		if (fatherLastName == null) {
			if (other.fatherLastName != null)
				return false;
		} else if (!fatherLastName.equals(other.fatherLastName))
			return false;
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (!fee.equals(other.fee))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (motherFirstName == null) {
			if (other.motherFirstName != null)
				return false;
		} else if (!motherFirstName.equals(other.motherFirstName))
			return false;
		if (motherLastName == null) {
			if (other.motherLastName != null)
				return false;
		} else if (!motherLastName.equals(other.motherLastName))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (studentAddress == null) {
			if (other.studentAddress != null)
				return false;
		} else if (!studentAddress.equals(other.studentAddress))
			return false;
		if (studentFirstName == null) {
			if (other.studentFirstName != null)
				return false;
		} else if (!studentFirstName.equals(other.studentFirstName))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentLastName == null) {
			if (other.studentLastName != null)
				return false;
		} else if (!studentLastName.equals(other.studentLastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", admisstionNubmer=" + admisstionNubmer + ", studentFirstName="
				+ studentFirstName + ", studentLastName=" + studentLastName + ", fatherFirstName=" + fatherFirstName
				+ ", fatherLastName=" + fatherLastName + ", motherFirstName=" + motherFirstName + ", motherLastName="
				+ motherLastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", grade=" + grade
				+ ", section=" + section + ", academicYear=" + academicYear + ", studentAddress=" + studentAddress
				+ ", fee=" + fee + "]";
	}

	 
	 
}
