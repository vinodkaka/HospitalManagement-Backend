package com.spring.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Doctor")

public class Doctor {
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @NotNull
	private int doctorId;
	@NotEmpty
	private String doctorName;
	@NotEmpty
	private String department;
	@NotEmpty
	private String specialization;
	@NotNull
	private double contactNumber;
	public Doctor(int doctorId, String doctorName, String department, String specialization, double contactNumber) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.department = department;
		this.specialization = specialization;
		this.contactNumber = contactNumber;
	}
	public Doctor() {
		super();
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public double getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(double contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	}

	/*
	 * private String patientName; private String patientDisease; private String
	 * description;
	 */
	