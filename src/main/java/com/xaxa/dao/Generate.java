package com.xaxa.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("generate")
public class Generate <T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public T add(T object) throws Exception {
		try {
			sessionFactory.getCurrentSession().save(object);
		} catch (Exception e) {
			throw new Exception();
		}
		return object;
	}
	
	@Transactional
	public void update(T object) throws Exception {
		try {
			sessionFactory.getCurrentSession().update(object);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public void delete (T object) throws Exception {
		try {
			sessionFactory.getCurrentSession().delete(object);
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
