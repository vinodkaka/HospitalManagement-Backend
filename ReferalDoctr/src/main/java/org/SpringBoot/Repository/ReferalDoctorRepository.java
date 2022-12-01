package org.SpringBoot.Repository;

import org.SpringBoot.Model.ReferalDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferalDoctorRepository extends JpaRepository<ReferalDoctor, Integer> {

	
	public ReferalDoctor findByrefralDoctorName(String refralDoctorName);
}
