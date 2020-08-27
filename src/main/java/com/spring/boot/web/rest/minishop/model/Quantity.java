package com.spring.boot.web.rest.minishop.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class Quantity {
	
	@NotEmpty(message = "Product code is required!")
	private String code;
	
	@PositiveOrZero(message = "Quantity must be zero and above!")
	private int  quantity;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	

}
