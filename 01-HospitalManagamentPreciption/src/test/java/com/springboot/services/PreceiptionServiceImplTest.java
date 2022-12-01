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

import com.springboot.model.Preceiption;
import com.springboot.repository.PreceiptionRepository;

@ExtendWith(SpringExtension.class)
class PreceiptionServiceImplTest {

	@Mock
	PreceiptionRepository prescription;
    
	@InjectMocks
	PreceiptionServiceImpl preserviceimpl;
	
	Preceiption prescription1;
	Preceiption prescription2;
	List<Preceiption> prescriptionList;
	
	@BeforeEach
	void setUP() {
		
		prescription1=new Preceiption(1,"xyz",1,"tdg");
		prescription2=new Preceiption(2,"agvdsvc",2,"jsacgvcgsc");
		prescriptionList=Arrays.asList(prescription1,prescription2);
	}
	
	@Test
	void testaddprescription() {
		prescription.save(prescription1);
	}
	
	@Test
	void tesrfetchprescription() {
		when(prescription.findAll()).thenReturn(prescriptionList);
		List<Preceiption> prescriptiontlist=preserviceimpl.fetchall();
		assertEquals(prescriptionList,prescriptiontlist);
	}
	
	@Test
	void testfindrefechprescriptionById() {
		when(prescription.findById(1)).thenReturn(Optional.of(prescription1));
		assertThat(preserviceimpl.fetchUserById(1).get()).isEqualTo(prescription1);
	}
}
