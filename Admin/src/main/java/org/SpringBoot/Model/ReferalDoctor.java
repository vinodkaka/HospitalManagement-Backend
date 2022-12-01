package org.SpringBoot.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class ReferalDoctor {

	
	int refralDoctorId;
	String refralDoctorName;
	String department;
	String specialiasation;
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
	
	
}
