package org.SpringBoot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.SpringBoot.Exception.ErrorDetails;
import org.SpringBoot.Exception.ResourceNotFoundException;
import org.SpringBoot.Model.ReferalDoctor;
import org.SpringBoot.Repository.ReferalDoctorRepository;
import org.SpringBoot.Service.ReferalDoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReferaldoctorController {

	@Autowired
	ReferalDoctorRepository referaldoctorrepository;
	
	@Autowired
	ReferalDoctorService referaldoctorService;
	
	Logger logger = LoggerFactory.getLogger(ReferalDoctor.class);
	
	@PostMapping(value="/add")
	public void addreferaldoctor(@Valid @RequestBody ReferalDoctor referaldoctor)
	{
		logger.info("ReferalDoctor have been added sucessfully");
		referaldoctorService.addReferalDoctor(referaldoctor);
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/fetch")
    public List<ReferalDoctor> getAllDoctors()
    {
		
        List<ReferalDoctor> referaldoctor=referaldoctorService.fetchAllreferalDoctor();
        logger.info("List of referal doctors is fetched sucessfully");
        return referaldoctor;
    }
	
	@GetMapping("/fetchByName/{refralDoctorName}")
	public ReferalDoctor getDoctorByName(@PathVariable("refralDoctorName") String refralDoctorName){
		
		ReferalDoctor referaldoctor=referaldoctorrepository.findByrefralDoctorName(refralDoctorName);
		logger.info("ReferalDoctor with the given name is fetched sucessfully");
		return referaldoctor;
	}
	

	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<ReferalDoctor> getDoctorById(@PathVariable("id") int id)
	{
		Optional<ReferalDoctor> referaldoctor=referaldoctorService.fetchreferalDoctorById(id);
		if(referaldoctor.isPresent()) {
			logger.info("ReferalDoctor with the given id is fetched sucessfully");
		 return ResponseEntity.ok(referaldoctor.get());
		 }
		 throw new ResourceNotFoundException("There is no docotor present with the given Doctor Id ");
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
