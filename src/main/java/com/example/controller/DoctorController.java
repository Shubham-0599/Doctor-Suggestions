package com.example.controller;

import java.util.List;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Doctor;
import com.example.service.DoctorService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("doctor")
public class DoctorController {
	@Autowired private DoctorService doctorService;
	
	@PostMapping("add")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor){
		doctorService.saveDoctor(doctor);
	return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}
	@GetMapping("list")
	public ResponseEntity<List<Doctor>> getDoctorList(){
		List<Doctor>doctorList= doctorService.getDoctorList();
		return ResponseEntity.status(HttpStatus.OK).body(doctorList);
			
	}
	@GetMapping("details/{did}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable int did){
		Doctor doctor=doctorService.getDoctor(did);
		return ResponseEntity.status(HttpStatus.OK).body(doctor);
	}
	@DeleteMapping("delete")
	public ResponseEntity<Doctor>deleteDoctor(@RequestParam int did){
		Doctor doctor= doctorService.getDoctor(did);
		doctorService.deleteDoctor(did);
		return ResponseEntity.status(HttpStatus.OK).body(doctor);
			
	}


}
