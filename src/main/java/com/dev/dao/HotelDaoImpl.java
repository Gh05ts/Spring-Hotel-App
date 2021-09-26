package com.dev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.model.Hotel;

@Repository
public class HotelDaoImpl implements HotelDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Hotel getHotel(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Hotel.class, id);
	}
	
	@Override
	@Transactional
	public List<Hotel> getAllHotels() {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Hotel> ret = currentSession.createCriteria(Hotel.class).list();
		return ret;		
	}
}
