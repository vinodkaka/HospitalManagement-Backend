package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.Exception.DataNotFoundException;
import com.springboot.model.Preceiption;
import com.springboot.services.PreceiptionService;

@RestController
public class PreceiptionController {

	@Autowired
	PreceiptionService preceiptionService;
	 @Autowired
	   RestTemplate restTemplate;

	 //@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/fetch")
	public List<Preceiption> getAllprescriptions() {
		return preceiptionService.fetchall();
	}

	@PostMapping(value = "/add")
	public void addPreceiption(@RequestBody Preceiption preceiption) {
		preceiptionService.addPreceiption(preceiption);
	}

	@GetMapping("/fetchById/{id}")
	public ResponseEntity<Preceiption> getPreceptionReport(@PathVariable("id") int id) {
		Optional<Preceiption> preceiption = preceiptionService.fetchUserById(id);
		if (preceiption.isPresent())
			return ResponseEntity.ok(preceiption.get());
		throw new DataNotFoundException("Invalid Preceiption");
	}

	@DeleteMapping("/deleteById/{id}")
	public void deletePreceiptionById(@PathVariable("id") int id) {
		preceiptionService.deletePreceiptionById(id);
	}
	

	@PutMapping(value = "/updateById/{id}")
	public void updatePost(@PathVariable int id, @RequestBody Preceiption preceiption) {

		preceiptionService.updateprecription(id, preceiption);

	}

}
