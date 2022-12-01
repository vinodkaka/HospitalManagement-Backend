package com.SpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="AppointmentTable")
public class Appointment {
	
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	public int AppointmentNo;
	@NotNull
	public int PatientId;
	@NotEmpty
	public String PatientName;
	@NotNull
	public int DoctorId;
	
	public Appointment(int appointmentNo, int patientId, String patientName, int doctorId) {
		super();
		this.AppointmentNo = appointmentNo;
		this.PatientId = patientId;
		this.PatientName = patientName;
		this.DoctorId = doctorId;
	}
	
	public Appointment() {
		
		// TODO Auto-generated constructor stub
	}
	public int getAppointmentNo() {
		return AppointmentNo;
	}
	public void setAppointmentNo(int appointmentNo) {
		this.AppointmentNo = appointmentNo;
	}
	public int getPatientId() {
		return PatientId;
	}
	public void setPatientId(int patientId) {
		this.PatientId = patientId;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		this.PatientName = patientName;
	}
	public int getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(int doctorId) {
		this.DoctorId = doctorId;
	}
	@Override
	public String toString() {
		return "Appointment [AppointmentNo=" + AppointmentNo + ", PatientId=" + PatientId + ", PatientName="
				+ PatientName + ", DoctorId=" + DoctorId + "]";
	}
	
	
	

}
