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
public class Patient {
	@Id
	@GeneratedValue(generator = "pat_seq")
	@SequenceGenerator(name="pat_seq",initialValue = 1001,allocationSize = 1)
	
	private int patid;
	@NotNull(message = "Name is required")
	@Size(min=3,message = "Only albhates and space allow in name and length must be minimum 3")
	private String name;
	@Size(max=20,message = "city should be at 20 characters")
	@NotNull(message = "City is required")
	private String city;
	@Column(unique = true,length = 100)
	@Email(message = "Email is required/invalid")
	private String email;
	@Column(unique = true,length = 20)
	@NotNull(message = "Mobile no. is required")
	@Size(min = 10,message = "Phone no. must have atleast 10 digits")
	private String phone;
	@NotNull(message = "Symptoms is required let the doctors know about your symptoms")
	@Pattern(regexp = "ARTHRITIS|BACKPAIN|TISSUE INJURY|DYSMENORREHA|SKIN BURN|EAR PAIN|SKIN INFECTION",message = "Inavlid Symptoms")
	private String symptoms;
	public int getDocid() {
		return patid;
	}
	public void setpatid(int patid) {
		this.patid = patid;
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
	public String getsymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
}
