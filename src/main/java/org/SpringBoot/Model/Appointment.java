package org.SpringBoot.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int PatientId;
	
	String PatientName;
	String DoctorName;
	int DoctorId;
	String Department;
	Date date;
	public int getPatientId() {
		return PatientId;
	}
	public void setPatientId(int patientId) {
		PatientId = patientId;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
	public int getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(int doctorId) {
		DoctorId = doctorId;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appointment [PatientId=" + PatientId + ", PatientName=" + PatientName + ", DoctorName=" + DoctorName
				+ ", DoctorId=" + DoctorId + ", Department=" + Department + ", date=" + date + "]";
	}
	
	
}
