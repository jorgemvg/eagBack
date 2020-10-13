package com.wog.eag.config.exception;

public class JDBCConnectionException extends RuntimeException{

	public JDBCConnectionException() {
		super();
	}

	public JDBCConnectionException(String message) {
		super(message);
	}

}
