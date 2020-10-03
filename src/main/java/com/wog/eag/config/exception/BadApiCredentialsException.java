package com.wog.eag.config.exception;

public class BadApiCredentialsException extends RuntimeException{

	public BadApiCredentialsException() {
		super();
	}

	public BadApiCredentialsException(String message) {
		super(message);
	}

}
