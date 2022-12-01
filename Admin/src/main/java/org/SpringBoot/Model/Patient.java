package org.SpringBoot.Model;

public class Patient {
      
	
	public int patientid;
	public String patientname;
	public int patientage;
	public String patientaddress;
	public long patientContactNumber;
	public String disease;
	public String referaldoctor;
	
	public Patient(int patientid, String patientname, int patientage, String patientaddress, long patientContactNumber,
			String disease, String referaldoctor) {
		super();
		this.patientid = patientid;
		this.patientname = patientname;
		this.patientage = patientage;
		this.patientaddress = patientaddress;
		this.patientContactNumber = patientContactNumber;
		this.disease = disease;
		this.referaldoctor = referaldoctor;
	}
	public Patient() {
		super();
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public int getPatientage() {
		return patientage;
	}
	public void setPatientage(int patientage) {
		this.patientage = patientage;
	}
	public String getPatientaddress() {
		return patientaddress;
	}
	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}
	public long getPatientContactNumber() {
		return patientContactNumber;
	}
	public void setPatientContactNumber(long patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getReferaldoctor() {
		return referaldoctor;
	}
	public void setReferaldoctor(String referaldoctor) {
		this.referaldoctor = referaldoctor;
	}
	
	
}
