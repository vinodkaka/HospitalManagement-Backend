package com.spring.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exceptionHandling.DataNotFoundException;
import com.exceptionHandling.ErrorDetails;
import com.spring.Model.Doctor;
import com.spring.Model.doctorpojo;
import com.spring.Repository.DoctorRepository;
import com.spring.Service.DoctorServices;



@RestController
public class DoctorController {
	
	@Autowired
	DoctorServices doctorServices;
	
	  @Autowired 
	  DoctorRepository doctorRepository;
	  
	  Logger logger = LoggerFactory.getLogger(Doctor.class);
	  
	  
	  @Autowired
	   RestTemplate restTemplate;
	  
	 // @PreAuthorize("hasRole('ADMIN')")
	  @RequestMapping(value = "/updatepatient/{id}", method = RequestMethod.PUT)
	   public String updatePatient(@PathVariable("id") String id,@Valid @RequestBody doctorpojo doctor) {
		   logger.info("Update Patient by Doctor");
		   
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<doctorpojo> entity = new HttpEntity<doctorpojo>(doctor,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8884/updateById/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	   

	   @RequestMapping(value = "/updateprescriptions/{id}", method = RequestMethod.PUT)
	   public String updatePrescriptions(@PathVariable("id") String id,@Valid @RequestBody doctorpojo doctor) {
		   logger.info("Update Prescription by Doctor");
		   
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<doctorpojo> entity = new HttpEntity<doctorpojo>(doctor,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8885/updateById/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	   
	  
	   
	   
	   
	   
	   @GetMapping("/prescriptionById/{id}")
	     public Doctor findPrescriptionById(@PathVariable int id ){
	        return doctorServices.findPrescriptionById(id);
	     }
	   
	   
	   @RequestMapping(value = "/delete/appointment/{id}", method = RequestMethod.DELETE)
	   public String deleteAppointment(@PathVariable("id") String id) {
		   logger.info("Delete By Appointment");
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Doctor> entity = new HttpEntity<Doctor>(headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8882/deleteById/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }
	

	@GetMapping("/fetch")
	public List<Doctor> getAllDoctors()
	{
		logger.info("Get a List of Doctor");
		List<Doctor> doctor=doctorServices.fetchAllDoctors();
		return doctor;
	}
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity< Doctor> getDoctorById(@PathVariable("id") int id)
	{
		logger.info("Get a Doctor By Id");
      Optional <Doctor> doctor= doctorServices.fetchDoctorById(id);
      if(doctor.isPresent())
    	  return ResponseEntity.ok(doctor.get());
		throw new DataNotFoundException("Doctor Name Invalid");
	}
	
	@PostMapping(value="/add")
	public void addDoctorInfo(@Valid @RequestBody Doctor doctor)
	{
		logger.info("Add a Doctor");
	 doctorServices.addDoctor(doctor);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deletebyId (@PathVariable("id") int id) {
		logger.info("Delete a Doctor");
		doctorServices.deletebyId(id);
		 
	}
	@PutMapping(value="/updateById/{id}")
    public void updatePost(@PathVariable int id,@Valid @RequestBody Doctor doctor) {
		logger.info("Update A Doctor By Id");

      doctorServices.updatePost(id, doctor);
}
	
	
	  @GetMapping("/fetchByName/{doctorName}") 
	  public Doctor getDoctorByName(@PathVariable("doctorName") String doctorname){
		  logger.info("Fetch Doctor By Name");
		  Doctor doctor=doctorRepository.findBydoctorName(doctorname);
		  return doctor; 
		  }
	  
	  @GetMapping("/fetchByDepartment/{department}") 
	  public Doctor getDoctorBydepartment(@PathVariable("department") String department){
		  logger.info("Fetch Doctor By Department");
		  Doctor doctor=doctorRepository.findBydepartment(department);
		  return doctor; 
		  }

    
	  @GetMapping("/getallreferaldoctors")
		public Object getAllreferaldoctors() {
		  logger.info("Get All ReferalDoctor");
			return doctorServices.getReferalDoctors();
		}
		
		@GetMapping("/fetchallreports")
		public Object getallreferaldoctors() {
			logger.info("Get All Report");
			return doctorServices.getReports();
		}
		
		@GetMapping("/fetchallappointments")
		public Object getallappointments() {
			logger.info("Get All Appointment");
			return doctorServices.getappointmentdetails();
		}
		
		
		@GetMapping("/fetchallprescriptions")
		public Object getallprescriptions() {
			logger.info("Get All Prescription");
			return doctorServices.getallprescriptions();
		}
		
		@GetMapping("/fetchallpatients")
		public Object getallpatients() {
			logger.info("Get All Patients");
			return doctorServices.getallpatients();
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