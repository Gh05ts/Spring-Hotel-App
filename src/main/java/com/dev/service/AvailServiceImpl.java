package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dao.AvailDao;
import com.dev.model.Availability;

@Service
public class AvailServiceImpl implements AvailService {

	@Autowired
	AvailDao availDao;

	@Override
	public List<Availability> checkAvail(String key) {
		return availDao.isAvailable(key);
	}

	@Override
	public void saveAvail(Availability avail) {
		// TODO Auto-generated method stub
		availDao.saveAvail(avail);
	}
	
	
}
