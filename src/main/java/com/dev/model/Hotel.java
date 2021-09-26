package com.dev.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {

	@Id
	Long id;
	String hotelName;
	String city;
	String roomType;
	Long price;
	Long gst;
	
	public Hotel() {
		super();
	}

	public Hotel(Long id, String hotelName, String city, String roomType, Long price, Long gst) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.city = city;
		this.roomType = roomType;
		this.price = price;
		this.gst = gst;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getGst() {
		return gst;
	}

	public void setGst(Long gst) {
		this.gst = gst;
	}

	
}
