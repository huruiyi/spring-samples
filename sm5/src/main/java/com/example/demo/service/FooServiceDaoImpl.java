package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;

public class FooServiceDaoImpl implements FooService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User doSomeBusinessStuff(String userId) {
		return this.userDao.getUser(userId);
	}
}
