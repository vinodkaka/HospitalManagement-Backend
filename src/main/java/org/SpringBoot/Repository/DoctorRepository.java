package org.SpringBoot.Repository;

import org.SpringBoot.Model.Admin;
import org.SpringBoot.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
