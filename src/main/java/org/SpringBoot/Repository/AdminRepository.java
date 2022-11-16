package org.SpringBoot.Repository;

import org.SpringBoot.Model.Admin;
import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Model.Doctor;
import org.SpringBoot.Model.Patient;
import org.SpringBoot.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	void save(Doctor doctor);

	void save(Patient patient);

	void save(Report report);

	void save(Appointment appointment);

	

	
	
}

