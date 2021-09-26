package com.dev.dao;

import java.util.List;
import java.util.Optional;

import com.dev.model.Availability;

public interface AvailDao {
	public void saveAvail(Availability avail);
	public List<Availability> isAvailable(String key);
	public Optional<Availability> getAvail(String key);
}
