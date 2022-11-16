package org.SpringBoot.Repository;

import org.SpringBoot.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	
}
