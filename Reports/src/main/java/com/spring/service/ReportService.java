package com.spring.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.spring.model.Report;

public interface ReportService {
	
	public void addReport(Report report);
	
	public void deleteReportbyId(int patientId);
	
	public Optional<Report> fetchReportsbyId(int patientId);
	
	public List<Report> fetchAllreports();
	
	public void updateReport(int patientId, Report report);
	
	
	

}
