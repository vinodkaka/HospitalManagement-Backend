package com.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PreceiptionTable")
public class Preceiption {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int preceiptionid;
	public int patientId;
	public String patientName;
	public int doctorId;
	public String description;
	public Preceiption(int patientId, String patientName, int doctorId, String description) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.doctorId = doctorId;
		this.description = description;
	}
	public Preceiption() {

		// TODO Auto-generated constructor stub
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
		return "Preceiption [patientId=" + patientId + ", patientName=" + patientName + ", doctorId=" + doctorId
				+ ", description=" + description + "]";
	}
	
	
	

}
