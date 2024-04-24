package com.example.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.exception.DoctorNotfoundException;
import com.example.exception.PatientNotFoundException;

@RestControllerAdvice
public class ValidAndExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Class<? extends Throwable>[] Exception = null;
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		BindingResult br=ex.getBindingResult();
		List<ObjectError> errorList=br.getAllErrors();
		List<String> list=new ArrayList<>();
		for(ObjectError error:errorList) {
			list.add(error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
	
	}
	@ExceptionHandler(DoctorNotfoundException.class)
	public ResponseEntity<Object> handleDoctorNotFoundException(DoctorNotfoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object>handlePatientNotFoundException(PatientNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());	
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
