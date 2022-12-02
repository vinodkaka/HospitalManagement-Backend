package com.spring.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.Model.Doctor;
import com.spring.Repository.DoctorRepository;


@Service
public  class DoctorServicesImpl implements DoctorServices {


    @Autowired
	 DoctorRepository doctorRepository ;
	
    @Autowired
    RestTemplate restTemplate;
    
    private String Get_Preceiption_By_ID="http://localhost:8000/fetchById/{id}";
    
   
    
	@Override
	public void addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorRepository.save(doctor);
		
	}

	@Override
	public Optional< Doctor> fetchDoctorById(int id) {
		// TODO Auto-generated method stub
 return doctorRepository.findById(id);
		
		
		
	}

	@Override
	public List<Doctor> fetchAllDoctors() {
		// TODO Auto-generated method stub
		List<Doctor> doctor=doctorRepository.findAll();
		return doctor;
		
	}

	@Override
	public void deletebyId(int id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
		
		
	}

	@Override
	public void updatePost(int id, Doctor doctor) {
		// TODO Auto-generated method stub
     Doctor doctor1 =doctorRepository.findById(id).orElse(null);
        
        doctor1.setDoctorName(doctor.getDoctorName());
        doctor1.setDoctorId(doctor.getDoctorId());
        doctor1.setDepartment(doctor.getDepartment());
        doctor1.setSpecialization(doctor.getSpecialization());
        doctor1.setContactNumber(doctor.getContactNumber());
        
        
        doctorRepository.save(doctor1);
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
	public Object getallprescriptions() {
		return restTemplate.getForObject("http://localhost:8885/fetch", Object.class);
	}
	
public Object getReferalDoctors() {
		
		return restTemplate.getForObject("http://localhost:8883/fetch", Object.class);
		
	}

@Override
public Doctor findPrescriptionById(int id) {

        Map<String,Integer> param=new HashMap<String,Integer>();
        param.put("id", id);
       
        return restTemplate.getForObject(Get_Preceiption_By_ID, Doctor.class, param);
        
    }}

	


	
	
			
	

	


	

