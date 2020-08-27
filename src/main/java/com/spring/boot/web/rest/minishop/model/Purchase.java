package com.spring.boot.web.rest.minishop.model;

import javax.validation.constraints.NotNull;

public class Purchase {
	@NotNull(message = "Product code must have a value!")
	private String productCode;
	private String userName;
	private int quantity;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Purchase [productCode=" + productCode + ", userName=" + userName + ", quantity=" + quantity + "]";
	}
	
}
