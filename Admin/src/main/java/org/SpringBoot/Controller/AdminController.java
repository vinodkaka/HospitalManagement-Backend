package org.SpringBoot.Controller;

import org.SpringBoot.Model.Admin;
import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Model.Doctor;
import org.SpringBoot.Model.Patient;
import org.SpringBoot.Model.ReferalDoctor;
import org.SpringBoot.Service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exceptionHandling.ErrorDetails;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminservice;	
	
	Logger logger = LoggerFactory.getLogger(Admin.class);
	
	@GetMapping("/fetchallreferaldoctors")
	public Object getAllreferaldoctors() {
		logger.info("all the referal doctors have been fetched sucessfully");
		return adminservice.getReferalDoctors();
	}
	
	@GetMapping("/fetchallreports")
	public Object getallreferaldoctors() {
		logger.info("reports of all the patients  have been fetched sucessfully");
		return adminservice.getReports();
	}
	
	@GetMapping("/fetchallappointments")
	public Object getallappointments() {
		logger.info("all apointments have been fetched sucessfully");
		return adminservice.getappointmentdetails();
	}
		
	@GetMapping("/fetchallpatients")
	public Object getallpatients() {
		return adminservice.getallpatients();
	}

	@GetMapping("/fetchalldoctors")
	public Object getalldoctors() {
		logger.info("all  doctors have been fetched sucessfully");
		return adminservice.getallDoctors();
	}
	
	@PostMapping("/addreferaldoctor")
	public Object addref(@RequestBody ReferalDoctor referaldoctor) {
		logger.info("referal doctors have been added sucessfully");
		return adminservice.addreferaldoctors(referaldoctor);
	}
	
	@PostMapping("/addappointment")
	public Object addappointment(@RequestBody Appointment appointment) {
		logger.info("appointment have been fetched sucessfully");
		return adminservice.addappointment(appointment);
	}
	
	@PostMapping("/adddoctor")
	public Object adddoctors(@RequestBody Doctor doctor) {
		logger.info(" doctor have been fetched sucessfully");
		return adminservice.addDoctor(doctor);
	}
	
	@PostMapping("/addpatient")
	public Object adddoctors(@RequestBody Patient patient) {
		logger.info("patient have been fetched sucessfully");
		return adminservice.addPatient(patient);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDetails exception (MethodArgumentNotValidException val) {
		ErrorDetails error= new ErrorDetails();
        val.getBindingResult().getAllErrors().forEach(e->{
        int errcode=HttpStatus.BAD_REQUEST.value();
        error.setErrorcode(errcode);
        String errmsg=e.getDefaultMessage();
        error.setErrormessage(errmsg);
                
        });
        return error;
	}
	
	}



