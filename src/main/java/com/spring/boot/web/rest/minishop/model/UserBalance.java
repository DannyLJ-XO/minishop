package com.spring.boot.web.rest.minishop.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserBalance {
	@NotEmpty(message = "User name is required!")
	private String userName;
	@NotNull
	private Float amount;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "UserBalance [userName=" + userName + ", amount=" + amount + "]";
	}
	
	
}
