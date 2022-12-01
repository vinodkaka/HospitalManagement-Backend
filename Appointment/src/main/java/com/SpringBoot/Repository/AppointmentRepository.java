package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Model.Appointment;



public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
