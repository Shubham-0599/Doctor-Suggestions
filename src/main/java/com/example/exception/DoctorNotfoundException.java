package com.example.exception;

public class DoctorNotfoundException extends RuntimeException{
	public DoctorNotfoundException(String msg) {
		super(msg);
	}

}
