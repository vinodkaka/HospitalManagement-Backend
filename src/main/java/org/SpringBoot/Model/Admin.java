package org.SpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospitaldetails")
public class Admin {
     
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int AdminId;
	String UserName;

	public int getAdminId() {
		return AdminId;
	}

	public void setAdminId(int adminId) {
		AdminId = adminId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	
	
	
}
