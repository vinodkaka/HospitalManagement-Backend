package org.SpringBoot.Service;

import java.util.List;

import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Override
	public void addAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
		
	}

	@Override
	public void cancelAppointment(Appointment appointment) {
		appointmentRepository.deleteById();
		
	}

	@Override
	public List<Appointment> fetchAllAppointments() {
		List<Appointment> appointment=appointmentRepository.findAll();
		return appointment;
	}

}
