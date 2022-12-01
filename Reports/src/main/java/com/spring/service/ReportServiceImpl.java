package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Report;
import com.spring.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportRepository reportRepository;

	@Override
	public void addReport(Report report) {
		// TODO Auto-generated method stub
		reportRepository.save(report);
	}



	@Override
	public void deleteReportbyId(int patientId) {
		// TODO Auto-generated method stub
		reportRepository.deleteById(patientId);
		
	}
	

	@Override
	public List<Report> fetchAllreports() {
		// TODO Auto-generated method stub
		List<Report> report = reportRepository.findAll();
		return report;
	}



	@Override
	public Optional<Report> fetchReportsbyId(int patientId) {
		// TODO Auto-generated method stub
		return reportRepository.findById(patientId);
	}


	@Override
	public void updateReport(int patientId, Report report) {
        // TODO Auto-generated method stub
     Report report1 =reportRepository.findById(patientId).orElse(null);
        
     report1.setPatientName(report.getPatientName());
     report1.setPatientDisease(report.getPatientDisease());
     report1.setDepartment(report.getDepartment());
     report1.setDoctorId(report.getDoctorId());
     report1.setDescription(report.getDescription());
    
        reportRepository.save(report1);
    }

	

}
