package com.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.SpringBoot.Model.Appointment;

public interface appointmentService {

	public void bookAppointment(Appointment appointment);
	public List<Appointment> fetchAllAppointment();
	public Optional<Appointment> fetchAppointmentById(int id);
	public void deleteAppointmentById(int id);
}
