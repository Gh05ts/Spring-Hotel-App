package com.dev.service;

import java.util.List;
import java.util.Set;

import com.dev.model.Hotel;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;

public interface HotelService {
	public Hotel getHotel(Long id);
	public Pair<Set<String>, String> getHotelHome();
}
