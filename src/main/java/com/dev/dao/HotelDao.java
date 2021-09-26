package com.dev.dao;

import java.util.List;

import com.dev.model.Hotel;

public interface HotelDao {
	public Hotel getHotel(Long id);
	public List<Hotel> getAllHotels();
}
