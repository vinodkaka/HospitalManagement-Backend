package org.SpringBoot.Service;

import java.util.List;

import org.SpringBoot.Model.Admin;
import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Model.Doctor;
import org.SpringBoot.Model.Patient;
import org.SpringBoot.Model.Report;
import org.SpringBoot.Repository.AdminRepository;
import org.SpringBoot.Repository.AppointmentRepository;
import org.SpringBoot.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	
	
	@Override
	public void addDoctor(Doctor doctor) {
		adminRepository.save(doctor);
	}
	

	@Override
	public void addPatient(Patient patient) {
		adminRepository.save(patient);
	}

	

	@Override
	public List<Patient> fetchAllPatient() {
		return null;
	}

	@Override
	public void addReport(Report report) {
		adminRepository.save(report);
	
	}

	@Override
	public void addAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);

			}

	

	@Override
	public void cancelAppointment(Appointment appointment) {
		adminRepository.save(appointment);
	}

	
}
