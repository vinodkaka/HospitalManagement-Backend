package com.spring.Service;

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

import com.spring.Model.Doctor;
import com.spring.Repository.DoctorRepository;

@ExtendWith(SpringExtension.class)
class DoctorServicesImplTest {

	@Mock
	DoctorRepository doctorrepository;
	
	@InjectMocks
	DoctorServicesImpl doctorservice;
	
	Doctor doctor1;
	Doctor doctor2;
	List<Doctor> doctorList;
	
	@BeforeEach
	void setUP() {
		doctor1=new Doctor(1,"vinod","dfh","gfdfg",1234);
		doctor2=new Doctor(2,"chidrup","wfd","sjc",2879);
		doctorList=Arrays.asList(doctor1,doctor2);
	}
	
	@Test
	void testaddDoctor() {
		doctorrepository.save(doctor1);
	}
	
	@Test
	void tesrfetchDoctor() {
		when(doctorrepository.findAll()).thenReturn(doctorList);
		List<Doctor> doctotlist=doctorservice.fetchAllDoctors();
		assertEquals(doctorList,doctotlist);
	}
	
	@Test
	void testfinddoctorById() {
		when(doctorrepository.findById(1)).thenReturn(Optional.of(doctor1));
		assertThat(doctorservice.fetchDoctorById(1).get()).isEqualTo(doctor1);
	}
}
