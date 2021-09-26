package com.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Availability", indexes = @Index(unique = true, columnList = "availStatus"))
public class Availability {

	@Id
	@GenericGenerator(name="keygen", strategy = "increment")
	@GeneratedValue(generator = "keygen")
	Long id;
	@Column(length = 190, unique = true, nullable = false)
	String availStatus;
	String guestName;
	String gender;
	long age;
	String email;
	String mobileNo;
	
	public Availability(String availStatus, String guestName, String gender, long age, String email,
			String mobileNo) {
		super();
		this.availStatus = availStatus;
		this.guestName = guestName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	
	public Availability() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public String getAvail_status() {
		return availStatus;
	}
	public void setAvail_status(String avail_status) {
		this.availStatus = avail_status;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
