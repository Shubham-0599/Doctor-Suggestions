package com.example.service;

import java.util.List;

import com.example.model.Doctor;
import com.example.model.Patient;

import jakarta.validation.Valid;

public interface PatientService {

	void savePatient(@Valid Patient patient);

	Patient getPatient(int pid);

	List<Doctor> getList(int pid);

}
