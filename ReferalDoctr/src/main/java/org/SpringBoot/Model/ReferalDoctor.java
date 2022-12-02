package org.SpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class ReferalDoctor {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull(message="id must not be null")
	int refralDoctorId;
	@NotEmpty(message="Doctor name must not be null")
	String refralDoctorName;
	@NotEmpty(message="Department must not be null")
	String department;
	@NotEmpty(message="Specialiasation must be added")
	String specialiasation;
	
	
	public ReferalDoctor() {
	}
	
	public ReferalDoctor(int refralDoctorId, String refralDoctorName, String department, String specialiasation) {
		this.refralDoctorId = refralDoctorId;
		this.refralDoctorName = refralDoctorName;
		this.department = department;
		this.specialiasation = specialiasation;
	}
	public int getRefralDoctorId() {
		return refralDoctorId;
	}
	public void setRefralDoctorId(int refralDoctorId) {
		this.refralDoctorId = refralDoctorId;
	}
	public String getRefralDoctorName() {
		return refralDoctorName;
	}
	public void setRefralDoctorName(String refralDoctorName) {
		this.refralDoctorName = refralDoctorName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSpecialiasation() {
		return specialiasation;
	}
	public void setSpecialiasation(String specialiasation) {
		this.specialiasation = specialiasation;
	}
	@Override
	public String toString() {
		return "ReferalDoctor [refralDoctorId=" + refralDoctorId + ", refralDoctorName=" + refralDoctorName
				+ ", department=" + department + ", specialiasation=" + specialiasation + "]";
	}
}
