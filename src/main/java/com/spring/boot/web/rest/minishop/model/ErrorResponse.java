package com.spring.boot.web.rest.minishop.model;

public class ErrorResponse {
	private String message;

	public ErrorResponse(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
