package com.dev.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.model.Availability;

@Repository
public class AvailDaoImpl implements AvailDao {

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	@Transactional
	public void saveAvail(Availability avail) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(avail);
	}

	@Override
	@Transactional
	public List<Availability> isAvailable(String key) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = "FROM Availability A WHERE A.availStatus = :availStatus";
		Query query = currentSession.createQuery(hql);
		query.setParameter("availStatus", key);
		List<Availability> result = query.list();
		return result;
	}

	@Override
	@Transactional
	public Optional<Availability> getAvail(String key) {
		Session currentSession = sessionFactory.getCurrentSession();
		return null;
	}

}
