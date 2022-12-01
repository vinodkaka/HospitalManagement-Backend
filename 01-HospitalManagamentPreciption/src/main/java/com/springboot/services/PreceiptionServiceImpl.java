package com.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springboot.model.Preceiption;
import com.springboot.repository.PreceiptionRepository;

@Component
public class PreceiptionServiceImpl  implements PreceiptionService {

	
	@Autowired	
	PreceiptionRepository preceiptionRepository;
	
	@Autowired
	 RestTemplate restTemplate; 
	
	@Override
	public void addPreceiption(Preceiption preceiption) {
		preceiptionRepository.save( preceiption);

	}

	@Override
	public void deletePreceiptionById(int id) {
		
		preceiptionRepository.deleteById(id);
	
		
	}

	@Override
	public Optional<Preceiption> fetchUserById(int id) {
		
		return preceiptionRepository.findById(id);

		
	}

	

	@Override
	public void updateprecription(int id, Preceiption preceiption) {
		  Preceiption preception1 =preceiptionRepository.findById(id).orElse(null);
	        
		  preception1.setDoctorId(preceiption.getDoctorId());
		  preception1.setPatientId(preceiption.getPatientId());
		  preception1.setPatientName(preceiption.getPatientName());
		  preception1.setDescription(preceiption.getDescription());
		  
	     
	        
	        
	        preceiptionRepository.save(preceiption);
		
	}

	@Override
	public List<Preceiption> fetchall() {
		List<Preceiption> prescription=preceiptionRepository.findAll();
		return prescription;
	}

	

}
