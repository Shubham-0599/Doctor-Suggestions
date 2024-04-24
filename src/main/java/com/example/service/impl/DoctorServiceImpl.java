package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.DoctorNotfoundException;
import com.example.model.Doctor;
import com.example.repository.DoctorRepository;
import com.example.service.DoctorService;

import jakarta.validation.Valid;
@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired private DoctorRepository doctorRepo;


	public void saveDoctor(@Valid Doctor doctor) {
		doctorRepo.save(doctor);
	}

	public List<Doctor> getDoctorList() {
		
		return doctorRepo.findAll();
	}

	public Doctor getDoctor(int did) {
		Doctor doctor=doctorRepo.findById(did).orElseThrow(()->new DoctorNotfoundException("Doctor with id:" +did+ "not found"));
		return doctor ;
	}

	public void deleteDoctor(int did) {
		doctorRepo.deleteById(did);
	}

}
