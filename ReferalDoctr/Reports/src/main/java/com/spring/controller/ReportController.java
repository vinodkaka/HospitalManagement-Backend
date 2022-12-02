package com.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.DataNotFoundException;
import com.spring.exception.ErrorDetails;
import com.spring.model.Report;
import com.spring.service.ReportService;

@RestController
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	Logger logger = LoggerFactory.getLogger(Report.class);

	
	@PostMapping("/add")
	public void addPatientReport(@Valid @RequestBody Report report)
	{
		reportService.addReport(report);
		logger.info("reports have been added");
	}
	
	@DeleteMapping("/deleteById/{patientId}")
	public void deleteReportbyId(@PathVariable("patientId") int patientId)
	{
		reportService.deleteReportbyId(patientId);
		logger.info("reports with the given id is deleted");
	}
	
	@GetMapping("/fetchById/{patientId}")
	public ResponseEntity<Report> fetchreportbyId(@PathVariable("patientId") int patientId)
	{
		Optional<Report> report=reportService.fetchReportsbyId(patientId);
		if(report.isPresent()) {
			logger.info("report with the given id is fetched");
			return ResponseEntity.ok(report.get());
			}
		throw new DataNotFoundException("Invalid Report");
	}

	/* @PreAuthorize("hasRole('ADMIN')") */
	@GetMapping("/fetch")
	public List<Report> fetchAll(){
		List<Report> report=reportService.fetchAllreports();
		logger.info("list of reports have been fetched");
		return report;
	}
	@PutMapping(value="/updateById/{patientId}")
    public void updatePost(@PathVariable int patientId,@Valid @RequestBody Report report) {
     reportService.updateReport(patientId, report);
     logger.info("report with the given id is updated");
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
