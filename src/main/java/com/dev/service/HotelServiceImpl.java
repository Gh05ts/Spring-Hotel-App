package com.dev.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dao.HotelDao;
import com.dev.model.Hotel;
import com.google.gson.Gson;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;


@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelDao hotelDao;
	
	@Override
	public Hotel getHotel(Long id) {
		return hotelDao.getHotel(id);
	}
	
	@Override
	public Pair<Set<String>, String> getHotelHome() {
		List<Hotel> allHotels = hotelDao.getAllHotels();
		Map<String, List<Map<String, Object>>> cityNameId = new HashMap<String, List<Map<String, Object>>>();
		Set<String> cities = new HashSet<String>();
		allHotels.forEach(item -> {
			String city = item.getCity();
			cities.add(city);
			if(!cityNameId.containsKey(city)) {
				cityNameId.put(city, new ArrayList<Map<String, Object>>());
			}
			cityNameId.get(city).add(Map.of("name", item.getHotelName(),"id", item.getId()));
		});
		Gson gson = new Gson();
		return new Pair<Set<String>, String>(cities, gson.toJson(cityNameId));
	};
}
