package com.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.model.Appointment;
import com.springboot.model.Patient;
import com.springboot.repository.PatientRepository;


@Service
public class PatientServicesImpl implements PatientServices {
	

	@Autowired	
	PatientRepository patientRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public void addPatient(Patient patient) {
		patientRepository.save(patient)	;

	}
	

	@Override
	public List<Patient> fetchAllUsers() {
		List<Patient> patient=patientRepository.findAll();
		return patient;
		
	}


	

	@Override
	public Optional<Patient> fetchUserById(int id) {
			return patientRepository.findById(id);
	}


	@Override
	public void deletePatientById(int id) {
		patientRepository.deleteById(id);
	}

	@Override
	public Patient findBypatientname(String patientname) {
		Patient patient=patientRepository.findBypatientname(patientname);
		return patient;
	}


	@Override
	public Object getReports() {
		return restTemplate.getForObject("http://localhost:8081/fetch", Object.class);
		
	}
	
	@Override
	public Object getappointmentdetails() {
		return restTemplate.getForObject("http://localhost:8882/fetch", Object.class);
	}


	@Override
	public Object getallprescriptions() {
		return restTemplate.getForObject("http://localhost:8885/fetch", Object.class);
	}


	@Override
	public Object getallDoctors() {
		return restTemplate.getForObject("http://localhost:8883/fetch", Object.class);
	}


	@Override
	public Object addappointment(Appointment appointment) {
		Appointment appointment1 = new Appointment();
		 appointment1.setAppointmentNo(appointment1.getAppointmentNo());
		 appointment1.setPatientId(appointment1.getPatientId());
		 appointment1.setPatientName(appointment1.getPatientName());
		 appointment1.setDoctorId(appointment1.getDoctorId());
		 return restTemplate.postForObject("http://localhost:8882/add",appointment, Appointment.class);
	}


	@Override
	public void updatepatient(int id, Patient patient) {
		  Patient patient1 =patientRepository.findById(id).orElse(null);
          
          patient1.setPatientname(patient.getPatientname());
          patient1.setPatientid(patient.getPatientid());
          patient1.setPatientage(patient.getPatientage());
          patient1.setDisease(patient.getDisease());
          patient1.setPatientaddress(patient.getPatientaddress());
          patient1.setPatientContactNumber(patient.getPatientContactNumber());
          patient1.setReferaldoctor(patient.getReferaldoctor());
         
            patientRepository.save(patient1);		
	}
}
