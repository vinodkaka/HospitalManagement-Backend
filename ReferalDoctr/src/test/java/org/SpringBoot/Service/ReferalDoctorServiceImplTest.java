package org.SpringBoot.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.SpringBoot.Model.ReferalDoctor;
import org.SpringBoot.Repository.ReferalDoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ReferalDoctorServiceImplTest {
	
	@Mock
	ReferalDoctorRepository referaldoctorRepository;
	
	@InjectMocks
	ReferalDoctorServiceImpl referalDoctorServiceIMPL;
	
	
	ReferalDoctor referaldoctor;
	ReferalDoctor referaldoctor1;
	List<ReferalDoctor> referaldoctorList;
	
	@BeforeEach
	void setUp() {
		referaldoctor=new ReferalDoctor(1,"vinod","xyz","xyz");
		referaldoctor1=new ReferalDoctor(2,"chidrup","abc","abc");
		referaldoctorList=Arrays.asList(referaldoctor,referaldoctor1);
		
	}

	@Test
	void testaddReferalDoctor() {
		//when(referaldoctorRepository.save(any())).thenReturn(referaldoctor):
		referaldoctorRepository.save(referaldoctor);
	}
	
	
	

	@Test
	void testfetchAllreferalDoctor() {
		when(referaldoctorRepository.findAll()).thenReturn(referaldoctorList);
		List<ReferalDoctor> referaldoctorlist=referalDoctorServiceIMPL.fetchAllreferalDoctor();
		assertEquals(referaldoctorList,referaldoctorlist);
	}

	@Test
	void testfindreferaldoctorById() {
		when(referaldoctorRepository.findById(1)).thenReturn(Optional.of(referaldoctor));
		assertThat(referalDoctorServiceIMPL.fetchreferalDoctorById(1).get()).isEqualTo(referaldoctor);
	}
}
