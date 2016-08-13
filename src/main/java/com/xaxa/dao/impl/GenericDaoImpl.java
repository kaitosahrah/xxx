package com.xaxa.dao.impl;

import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.xaxa.dao.GenericDao;
import com.xaxa.sessionFactory.SessionFactoryObject;

public abstract class GenericDaoImpl<T> extends SessionFactoryObject implements GenericDao<T> {

	public abstract Logger getLogger();

	@SuppressWarnings("rawtypes")
	public abstract Class getClassObject();

	@Transactional
	@SuppressWarnings("unchecked")
	public T add(T object) throws Exception {
		T objectExpected = (T) sessionFactory.getCurrentSession().save(object);
		sessionFactory.getCurrentSession().flush();
		return objectExpected;
	}

	@Transactional
	public T update(T object) throws Exception {
		sessionFactory.getCurrentSession().update(object);
		sessionFactory.getCurrentSession().flush();
		return object;
	}

	@Transactional
	public T delete(T object) throws Exception {
		sessionFactory.getCurrentSession().delete(object);
		sessionFactory.getCurrentSession().flush();
		return object;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public T getById(String id) throws Exception {
		T object = (T) sessionFactory.getCurrentSession().get(getClassObject(), id);
		return object;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public T getById(int id) throws Exception {
		T object = (T) sessionFactory.getCurrentSession().get(getClassObject(), id);
		return object;
	}
}
