package org.SpringBoot.Service;

import java.util.List;

import org.SpringBoot.Model.Appointment;

public interface AppointmentService {

	public void addAppointment(Appointment appointment);
	public void cancelAppointment(Appointment appointment);
	public List<Appointment> fetchAllAppointments();
	
}
