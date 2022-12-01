package org.SpringBoot.Service;

import java.util.List;

import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Model.Doctor;
import org.SpringBoot.Model.Patient;
import org.SpringBoot.Model.ReferalDoctor;

public interface AdminService {

	

	public Object getReferalDoctors();
	public Object getReports();
	public Object getappointmentdetails();
	public Object getallpatients();
	public Object getallDoctors();
	public Object addreferaldoctors(ReferalDoctor referaldoctor);
	public Object addappointment(Appointment appointment);
	public Object addDoctor(Doctor doctor);
	public Object addPatient(Patient patient);
	
	
	//public Object updatePatient(int id,Patient patient);
	
	
}
