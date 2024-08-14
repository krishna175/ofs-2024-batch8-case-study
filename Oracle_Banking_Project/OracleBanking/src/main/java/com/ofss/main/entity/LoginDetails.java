package com.ofss.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class LoginDetails {
	
	@Id
	private int customerId;
	private String username;
	private String password;
	private int loginAttempts;
	private String customerStatus;
	
	public LoginDetails(int customerId, String username, String password, int loginAttempts, String customerStatus) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.loginAttempts = loginAttempts;
		this.customerStatus = customerStatus;
	}


	public String getCustomerStatus() {
		return customerStatus;
	}


	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}


	@Override
	public String toString() {
		return "LoginDetails [customerId=" + customerId + ", username=" + username + ", password=" + password
				+ ", loginAttempts=" + loginAttempts + ", customerStatus=" + customerStatus + "]";
	}


	public int getLoginAttempts() {
		return loginAttempts;
	}


	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}


	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LoginDetails(int customerId, String username, String password) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
