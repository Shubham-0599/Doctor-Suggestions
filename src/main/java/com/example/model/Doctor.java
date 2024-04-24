package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name="doc_seq",initialValue = 111,allocationSize = 1)
	
	private int docid;
	@NotNull(message = "Name is required")
	private String name;
	@Pattern(regexp = "Noida|Delhi|Faridabad",message = "city must be either Noida Or Delhi or Faridabad")
	@NotNull(message = "City is required")
	private String city;
	@Column(unique = true,length = 100)
	@Email(message = "Email is required")
	private String email;
	@Column(unique = true,length = 20)
	@NotNull(message = "Mobile no. is required")
	@Size(min = 10,message = "Phone no. must have atleast 10 digits")
	private String phone;
	@NotNull(message = "Speciality is required")
	@Pattern(regexp = "ORTHOPEDIC|GYNECOLOGY|DERMATOLOGY|ENT",message = "Inavlid Speciality")
	private String speciality;
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
