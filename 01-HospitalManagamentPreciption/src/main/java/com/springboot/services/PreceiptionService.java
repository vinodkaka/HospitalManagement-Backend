package com.springboot.services;



import java.util.List;
import java.util.Optional;

import com.springboot.model.Preceiption;

public interface PreceiptionService {

	
	public void addPreceiption(Preceiption preceiption);
	public List<Preceiption> fetchall();
	public void deletePreceiptionById(int id);
	
	public Optional<Preceiption> fetchUserById(int id);


	public void updateprecription(int id, Preceiption preceiption);

}
