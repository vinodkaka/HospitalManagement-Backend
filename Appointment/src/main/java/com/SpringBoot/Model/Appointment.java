package com.SpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
//@Table(name="AppointmentTable")
public class Appointment {
	
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	public int appointmentNo;
	@NotNull
	public int patientId;
	@NotEmpty
	public String patientName;
	@NotNull
	public int doctorId;
	
	
	public Appointment() {
	}


	public Appointment( int appointmentNo,int patientId,String patientName,
			int doctorId) {
		this.appointmentNo = appointmentNo;
		this.patientId = patientId;
		this.patientName = patientName;
		this.doctorId = doctorId;
	}


	public int getAppointmentNo() {
		return appointmentNo;
	}


	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
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
	

	
}
