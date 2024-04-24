package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.PatientNotFoundException;
import com.example.model.Doctor;
import com.example.model.Patient;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import com.example.service.PatientService;
import com.example.utility.SymptomsMatcher;

import jakarta.validation.Valid;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired private PatientRepository patientRepo;
	@Autowired private DoctorRepository doctorRepo;

	public void savePatient(@Valid Patient patient) {
		patientRepo.save(patient);
	}

	public Patient getPatient(int pid) {
		Patient patient=patientRepo.findById(pid).orElseThrow(()->new PatientNotFoundException("Patient with id:"+pid+"not found"));
		return patient;
	}

	public List<Doctor> getList(int pid) {
		Patient patient=patientRepo.findById(pid).orElseThrow(()->new PatientNotFoundException("Patient with id:"+pid+"not found"));
		String city=patient.getCity();
		if(!city.equals("FARIDABAD") && !city.equals("NOIDA")&& city.equals("DELHI"))
		throw new RuntimeException("We are Still Waiting To Expand To Your Location");
		
		String symptoms=patient.getsymptoms();
		String speciality=SymptomsMatcher.map.get(symptoms);
		List<Doctor> doctorList=doctorRepo.getDoctorListBySpecialityAndCity(speciality,city);
		if(doctorList.isEmpty())
			throw new RuntimeException("There isn`t any doctor at your location for your symptoms");
		return doctorList;
		
		
	}

}
