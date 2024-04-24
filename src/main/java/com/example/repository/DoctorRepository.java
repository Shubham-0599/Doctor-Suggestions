package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	List<Doctor> getDoctorListBySpecialityAndCity(String speciality, String city);

}
