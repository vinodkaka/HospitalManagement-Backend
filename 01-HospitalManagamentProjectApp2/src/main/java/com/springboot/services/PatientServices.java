package com.springboot.services;

import java.util.List;
import java.util.Optional;

import com.springboot.model.Patient;
import com.springboot.model.Appointment;

public interface PatientServices {
	
	public void addPatient(Patient patient);
	public List<Patient> fetchAllUsers();
	public Optional<Patient> fetchUserById(int id);
	public void deletePatientById(int id);	
	public Patient findBypatientname(String patientname);
	
	
	public Object getReports();
	public Object getappointmentdetails();
	public Object getallprescriptions();
	public Object getallDoctors();
	
	public Object addappointment(Appointment appointment);
	
	

	


}
