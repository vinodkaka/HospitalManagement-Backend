package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.Exception.DataNotFoundException;
import com.springboot.Exception.ErrorDetails;
import com.springboot.model.Appointment;
import com.springboot.model.Patient;
import com.springboot.services.PatientServices;



@RestController

public class PatientController {
	
	@Autowired
	PatientServices  patientService;
	
	@Autowired
	RestTemplate resttemplate;
	
	@GetMapping("/fetchByName/{patientname}")
    public Patient getPatientByPatientname(@PathVariable("patientname") String Patientname){
		Patient patient= patientService.findBypatientname(Patientname);
        return patient;
    }
	
	@PutMapping(value = "/updateById/{id}")
    public void updatePost(@PathVariable int id, @RequestBody Patient patient) {
        //logger.info("Patie-Update by Id");
       patientService.updatepatient(id, patient);
   }

	  
	
	@PostMapping(value="/add")
	public void addUserInfo(@Valid @RequestBody Patient patient)
	{
		patientService.addPatient(patient);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/fetch")
	public List<Patient> getAllUsers()
	{
		List<Patient> user=patientService.fetchAllUsers();
		return user;
	}
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity <Patient> getUserById(@PathVariable("id") int id)
	{
		Optional<Patient> patient= patientService.fetchUserById(id);
		if(patient.isPresent())
			 return ResponseEntity.ok(patient.get());
			 throw new DataNotFoundException("Invalid patient");
	}
	
	
	
	

	
	@GetMapping("/fetchallreports")
	public Object getallreferaldoctors() {
		return patientService.getReports();
	}
	
	@GetMapping("/fetchallappointments")
	public Object getallappointments() {
		return patientService.getappointmentdetails();
	}
	
	
	@GetMapping("/fetchallprescriptions")
	public Object getallprescriptions() {
		return patientService.getallprescriptions();
	}
	
	@GetMapping("/fetchalldoctors")
	public Object getalldoctors() {
		return patientService.getallDoctors();
	}
	
	@PostMapping("/addappointment")
	public Object addappointment(@RequestBody Appointment appointment) {
		return patientService.addappointment(appointment);
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
