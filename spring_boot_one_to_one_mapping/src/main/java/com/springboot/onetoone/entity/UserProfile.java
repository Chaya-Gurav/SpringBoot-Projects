package com.springboot.onetoone.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "user_profiles")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="gender")
	private String gender;
//	private LocalDate dob
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "userProfile")
	private User user;
	public UserProfile() {
		
	}
	public UserProfile(String phoneNumber, String address, String gender) {
		super();
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.gender = gender;
	};

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
