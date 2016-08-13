package com.xaxa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.xaxa.dao.impl.UserDao;

public class UserService extends UserDao{
	@Autowired
	UserDao userDao;
	
}
