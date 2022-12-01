package org.SpringBoot.Service;

import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Model.Doctor;
import org.SpringBoot.Model.Patient;
import org.SpringBoot.Model.ReferalDoctor;
import org.SpringBoot.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.micrometer.core.ipc.http.HttpSender.Request;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminrepository;
	
	
	@Autowired
	RestTemplate restTemplate;


	public Object getReferalDoctors() {
		
		return restTemplate.getForObject("http://localhost:8883/fetch", Object.class);
		
	}

	@Override
	public Object getallpatients() {
		return restTemplate.getForObject("http://localhost:8884/fetch", Object.class);
	}

	@Override
	public Object getReports() {
		return restTemplate.getForObject("http://localhost:8886/fetch", Object.class);
		
	}
	
	@Override
	public Object getappointmentdetails() {
		return restTemplate.getForObject("http://localhost:8882/fetch", Object.class);
	}

	@Override
	public Object getallDoctors() {
		return restTemplate.getForObject("http://localhost:8883/fetch", Object.class);
	}


	
	

	@Override
	public Object addreferaldoctors(ReferalDoctor referaldoctor) {
		
		ReferalDoctor ref=new ReferalDoctor();
		ref.setRefralDoctorId(ref.getRefralDoctorId());
		ref.setRefralDoctorName(ref.getRefralDoctorName());
		ref.setDepartment(ref.getDepartment());
		ref.setSpecialiasation(ref.getSpecialiasation());
		

		return restTemplate.postForObject("http://localhost:8883/add",referaldoctor, ReferalDoctor.class);
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
	public Object addDoctor(Doctor doctor) {
		Doctor doc=new Doctor();
		doc.setDoctorId(doc.getDoctorId());
		doc.setDoctorName(doc.getDoctorName());
		doc.setDepartment(doc.getDepartment());
		doc.setSpecialization(doc.getSpecialization());
		doc.setContactNumber(doc.getContactNumber());
		
		return restTemplate.postForObject("http://localhost:8883/add", doctor,Doctor.class);
	}

	@Override
	public Object addPatient(Patient patient) {
		Patient patient1=new Patient();
		
		patient1.setPatientid(patient1.getPatientid());
		patient1.setPatientname(patient1.getPatientname());
		patient1.setPatientage(patient1.getPatientage());
		patient1.setPatientaddress(patient1.getPatientaddress());
		patient1.setPatientContactNumber(patient1.getPatientContactNumber());
		patient1.setDisease(patient1.getDisease());
		patient1.setReferaldoctor(patient1.getReferaldoctor());
		
		return restTemplate.postForObject("http://localhost:8884/add",patient,Patient.class);
		
	}

//	@Override
//	public Object updatePatient(int id, Patient patient) {
//       Patient patient1=new Patient();
//		
//		patient1.setPatientid(patient1.getPatientid());
//		patient1.setPatientname(patient1.getPatientname());
//		patient1.setPatientage(patient1.getPatientage());
//		patient1.setPatientaddress(patient1.getPatientaddress());
//		patient1.setPatientContactNumber(patient1.getPatientContactNumber());
//		patient1.setDisease(patient1.getDisease());
//		patient1.setReferaldoctor(patient1.getReferaldoctor());
//		
//		
//		//return restTemplate.exchange("http://localhost:8884/updateById/{id}", HttpMethod.PUT, Patient.class, patient, "id");
//	}

  

}
	

