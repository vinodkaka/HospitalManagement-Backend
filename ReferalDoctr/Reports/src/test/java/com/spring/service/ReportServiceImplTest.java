package com.spring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.model.Report;
import com.spring.repository.ReportRepository;

@ExtendWith(SpringExtension.class)
class ReportServiceImplTest {

	@Mock
	ReportRepository reportrepository;
	
	@InjectMocks
	ReportServiceImpl reportserviceimpl;
	

	Report report1;
	Report report2;
	List<Report> reportList;
	
	@BeforeEach
	void setUP() {
	 report1=new Report(1,"alex","xyz","cardiology",1,"gsfgavvducvsv");
	 report2=new Report(2,"arun","abc","physiotheraphy",2,"svycccsvsu");
	reportList=Arrays.asList(report1,report2);
	}
	
	@Test
	void testaddReport() {
		reportrepository.save(report1);
	}
	
	@Test
	void tesrfetchreport() {
		when(reportrepository.findAll()).thenReturn(reportList);
		List<Report> reportlist=reportserviceimpl.fetchAllreports();
		assertEquals(reportList,reportlist);
	}
	
	@Test
	void testfindreferaldoctorById() {
		when(reportrepository.findById(1)).thenReturn(Optional.of(report1));
		assertThat(reportserviceimpl.fetchReportsbyId(1).get()).isEqualTo(report1);
	}
}
