package com.example.exception;

public class ExceptionDTO {

    private final int errorCode;
	private final String message;

	public ExceptionDTO(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}
    
}
