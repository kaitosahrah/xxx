package com.xaxa.dao;

import org.springframework.stereotype.Component;

@Component("genericDao")
public interface GenericDao<T> {
	public T add(T object) throws Exception;

	public T update(T object) throws Exception;

	public T delete(T object) throws Exception;

	public T getById(String id) throws Exception;

	public T getById(int id) throws Exception;
}
