package com.SpringBoot.service;

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

import com.SpringBoot.Model.Appointment;
import com.SpringBoot.Repository.AppointmentRepository;

@ExtendWith(SpringExtension.class)
class AppointmentserviceImplTest {

	@Mock
	AppointmentRepository appointmentrepository;
	

	@InjectMocks
	AppointmentserviceImpl appointmentserviceimpl;
	
	Appointment appointment1;
	Appointment appointment2;
	List<Appointment> appointmentlist;
	
	@BeforeEach
	void setUP() {
		appointment1=new Appointment(1,1,"alex",1);
		appointment2=new Appointment(2,2,"arun",2);
		appointmentlist=Arrays.asList(appointment1,appointment2);
	}
	
	@Test
	void testaddappointment() {
		appointmentrepository.save(appointment1);
	}
	
	@Test
	void tesrfetchappointment() {
		when(appointmentrepository.findAll()).thenReturn(appointmentlist);
		List<Appointment> appointmentlist=appointmentserviceimpl.fetchAllAppointment();
		assertEquals(appointmentlist,appointmentlist);
	}
	
	@Test
	void testfindappointmentById() {
		when(appointmentrepository.findById(1)).thenReturn(Optional.of(appointment1));
		assertThat(appointmentserviceimpl.fetchAppointmentById(1).get()).isEqualTo(appointment1);
	}
}
