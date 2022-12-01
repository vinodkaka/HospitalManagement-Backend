package com.springboot.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springboot.model.Patient;
import com.springboot.repository.PatientRepository;

@ExtendWith(SpringExtension.class)
class PatientServicesImplTest {

	@Mock
	PatientRepository patientrepository;
	
	@InjectMocks
	PatientServicesImpl patientservicesimpl;
	
	
	Patient patient1;
	Patient patient2;
	List<Patient> patientlis;
	
	@BeforeEach
	void setUP() {
		patient1= new Patient(1,"vinod",22,"ftrxchg",1234,"ds","hdsv");
		patient2= new Patient(2,"chidrup",23,"dw",123,"jwgd","qbdc");
		patientlis=Arrays.asList(patient1,patient2);
	}
	
	@Test
	void testaddpatient() {
		patientrepository.save(patient1);
	}
	
	@Test
	void tesrfetchpatient() {
		when(patientrepository.findAll()).thenReturn(patientlis);
		List<Patient> patientList=patientservicesimpl.fetchAllUsers();
		assertEquals(patientlis,patientList);
	}
	
	@Test
	void testpatientbyId() {
		when(patientrepository.findById(1)).thenReturn(Optional.of(patient1));
		assertThat(patientservicesimpl.fetchUserById(1).get()).isEqualTo(patient1);
	}
}
