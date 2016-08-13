package com.xaxa.dao.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xaxa.model.User;

public class UserDao extends GenericDaoImpl<User>{
	private Logger logger = Logger.getLogger(UserDao.class.getName());
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClassObject() {
		return User.class;
	}
	
}
