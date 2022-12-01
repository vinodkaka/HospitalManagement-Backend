package org.SpringBoot.Service;

import java.util.List;
import java.util.Optional;

import org.SpringBoot.Model.ReferalDoctor;
import org.SpringBoot.Repository.ReferalDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferalDoctorServiceImpl implements ReferalDoctorService {

	@Autowired
	ReferalDoctorRepository referaldoctorRepository;

	@Override
	public void addReferalDoctor(ReferalDoctor referaldoctor) {
		referaldoctorRepository.save(referaldoctor);
	}

	@Override
	public List<ReferalDoctor> fetchAllreferalDoctor() {
		List<ReferalDoctor> referaldoctor=referaldoctorRepository.findAll();
		return referaldoctor;
	}


	
	@Override
	public Optional<ReferalDoctor> fetchreferalDoctorById(int id) {
		return referaldoctorRepository.findById(id);

	}


	
	
	
	
	

	
}
