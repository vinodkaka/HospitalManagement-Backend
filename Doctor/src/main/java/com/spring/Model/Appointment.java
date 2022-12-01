package com.spring.Model;

public class Appointment {

public int AppointmentNo;
	
	public int PatientId;
	public String PatientName;
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
