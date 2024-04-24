package com.example.service;

import java.util.List;

import com.example.model.Doctor;

import jakarta.validation.Valid;

public interface DoctorService {

	void saveDoctor(@Valid Doctor doctor);

	List<Doctor> getDoctorList();

	Doctor getDoctor(int did);

	void deleteDoctor(int did);

}
