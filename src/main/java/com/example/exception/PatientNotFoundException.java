package com.example.exception;

public class PatientNotFoundException extends RuntimeException {
	public PatientNotFoundException(String msg) {
		super(msg);
	}

}
