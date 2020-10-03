package com.wog.eag.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private HttpStatus status;
	private String message;
	private String method;
	private List<SubErrorResponse> subErrors;
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<SubErrorResponse> getSubErrors() {
		return subErrors;
	}
	public void setSubErrors(List<SubErrorResponse> subErrors) {
		this.subErrors = subErrors;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
