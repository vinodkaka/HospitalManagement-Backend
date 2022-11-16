package org.SpringBoot.Service;

import java.util.List;

import org.SpringBoot.Model.Admin;
import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Model.Doctor;
import org.SpringBoot.Model.Patient;
import org.SpringBoot.Model.Report;

public interface AdminService {

	public void addDoctor(Doctor doctor);
	public void addPatient(Patient patient);
	public List<Patient> fetchAllPatient();
	public void addReport(Report report);
	public void addAppointment(Appointment appointment);
	public void cancelAppointment(Appointment appointment);
	
}
