package com.spring.Model;

public class doctorpojo {private int patientid;
private String patientname;
private String description;



public int patientage;
public String patientaddress;
public long patientContactNumber;
public String disease;
public String referaldoctor;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
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
@Override
public String toString() {
	return "doctorpojo [patientid=" + patientid + ", patientname=" + patientname + ", description=" + description
			+ ", patientage=" + patientage + ", patientaddress=" + patientaddress + ", patientContactNumber="
			+ patientContactNumber + ", disease=" + disease + ", referaldoctor=" + referaldoctor + "]";
}



}
