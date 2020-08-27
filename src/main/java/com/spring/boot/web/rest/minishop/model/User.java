package com.spring.boot.web.rest.minishop.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class User {
	private Integer id;
	@NotEmpty(message = "user name is required!")
	private String userName;
	@NotEmpty(message = "Full Name is required!")
	private String fullName;
	private String address;

	private Float balance; 
	private Date registrationDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", fullName=" + fullName + ", address=" + address
				+ ", balance=" + balance + ", registrationDate=" + registrationDate + "]";
	}
	
	
}
