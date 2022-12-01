package com.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Model.Appointment;
import com.SpringBoot.Repository.AppointmentRepository;

@Service
public class AppointmentserviceImpl implements appointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public void bookAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
		
	}

	@Override
	public List<Appointment> fetchAllAppointment() {
		List<Appointment> appointment=appointmentRepository.findAll();
		return appointment;
	}

	@Override
	public Optional<Appointment> fetchAppointmentById(int id) {
		return appointmentRepository.findById(id);
	}
	
	
	@Override
    public void deleteAppointmentById(int id) {
        appointmentRepository.deleteById(id);
        
    }
	
	
}
