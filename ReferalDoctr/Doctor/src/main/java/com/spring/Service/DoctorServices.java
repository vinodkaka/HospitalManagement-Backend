package com.spring.Service;


import java.util.List;
import java.util.Optional;

import com.spring.Model.Doctor;



public interface DoctorServices {


	public void addDoctor(Doctor doctor);
	public List<Doctor> fetchAllDoctors();
	public Optional <Doctor> fetchDoctorById(int id) ;
	public void deletebyId(int id) ;
	public void updatePost(int id, Doctor doctor);
	
	public Object getReports();
	public Object getappointmentdetails();
	public Object getallprescriptions();
	public Object getallpatients();
	public Object getReferalDoctors();
	public Doctor findPrescriptionById(int id);
	
	
	
	}