package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Patient;


@Repository

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	

	public  Patient findBypatientname(String patientname);  
	
}
