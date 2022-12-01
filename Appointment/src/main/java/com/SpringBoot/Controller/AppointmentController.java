package com.SpringBoot.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.SpringBoot.Exception.ErrorDetails;
import org.SpringBoot.Exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Model.Appointment;
import com.SpringBoot.service.appointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	appointmentService appointmentservice;
	
	Logger logger = LoggerFactory.getLogger(Appointment.class);
	
	@PostMapping(value="/add")
	public void bookAppointment(@Valid @RequestBody Appointment appointment)
	{
		appointmentservice.bookAppointment(appointment);
		logger.info("Appointment have been booked");
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/fetch")
    public List<Appointment> getAllappointments()
    {
        List<Appointment> appointment=appointmentservice.fetchAllAppointment();
        logger.info("list of appointments have been fetched");
        return appointment;
    }
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<Appointment> getappointmentbyid(@PathVariable("id") int id)
	{
		Optional<Appointment> appointment=appointmentservice.fetchAppointmentById(id);
		if(appointment.isPresent()) {
			 logger.info("appointment with the given id have been fetched");
		 return ResponseEntity.ok(appointment.get());
		 }
		 throw new ResourceNotFoundException("There is no appointment present with the given patient Id ");
	}

	@DeleteMapping("/deleteById/{id}")
    public void deleteAppointmentById(@PathVariable("id") int id) {
        //logger.info("Preception-Delete by id");
        appointmentservice.deleteAppointmentById(id);
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
