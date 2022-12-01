package org.SpringBoot.Service;

import java.util.List;
import java.util.Optional;

import org.SpringBoot.Model.ReferalDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferalDoctorService  {

	
	public void addReferalDoctor(ReferalDoctor referaldoctor);
	//public void fetchreferalDoctorByDepartment(ReferalDoctor referaldoctor);
	public List<ReferalDoctor> fetchAllreferalDoctor();
	//public ReferalDoctor fetchreferalDoctorById(int id);
	public Optional<ReferalDoctor> fetchreferalDoctorById(int id);		
}
