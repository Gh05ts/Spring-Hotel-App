package com.dev.service;

import java.util.List;

import com.dev.model.Availability;

public interface AvailService {
	public List<Availability> checkAvail(String key);
	public void saveAvail(Availability avail);
}
