package com.spring.exception;

import java.util.Date;

public class ErrorDetails {
	private  String errormessage;
	private int errorcode;
	
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(String errormessage, int errorcode) {
		super();
		this.errormessage = errormessage;
		this.errorcode = errorcode;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	
	

	
	

}
