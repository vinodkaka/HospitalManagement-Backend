package com.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

	
	 public Doctor findBydoctorName(String name); 
	 public Doctor findBydepartment(String department);
	//public Report getReport(); 

}
