package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Doctor;
import com.example.model.Patient;
import com.example.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired private PatientService patService;
	
	@PostMapping("add")
	public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient){
		patService.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
		
	}
	@GetMapping("details")
	public ResponseEntity<Patient> getPatientDetails(@RequestParam int pid){
		Patient patient=patService.getPatient(pid);
		return ResponseEntity.ok(patient);
	}
	@GetMapping("doctor-list")
	public ResponseEntity<List<Doctor>> getDoctorList(@RequestParam int pid){
		List<Doctor> doctorList=patService.getList(pid);
		return ResponseEntity.ok(doctorList);
	}

}
