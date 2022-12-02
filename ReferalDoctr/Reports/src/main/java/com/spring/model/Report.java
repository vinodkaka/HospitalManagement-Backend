package com.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Patient")
public class Report {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull
	private int patientId;
	@NotEmpty(message="Patient name cannot be null")
	private String patientName;
	@NotEmpty(message="Patient disease cannot be null")
	private String patientDisease;
	@NotEmpty(message="department cannot be null")
	private String department;
	@NotNull(message="doctor id cannot be null")
	private int doctorId;
	private String description;
	
	
	
	public Report() {
		super();
	}
	public Report(int patientId, String patientName, String patientDisease, String department, int doctorId,
			String description) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientDisease = patientDisease;
		this.department = department;
		this.doctorId = doctorId;
		this.description = description;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientDisease() {
		return patientDisease;
	}
	public void setPatientDisease(String patientDisease) {
		this.patientDisease = patientDisease;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Report [patientId=" + patientId + ", patientName=" + patientName + ", patientDisease=" + patientDisease
				+ ", department=" + department + ", doctorId=" + doctorId + ", description=" + description + "]";
	}

}