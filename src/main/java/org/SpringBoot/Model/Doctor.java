package org.SpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {

	@Id
	int doctorId;

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + "]";
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
}
