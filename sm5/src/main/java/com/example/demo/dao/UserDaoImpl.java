package com.example.demo.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.example.demo.domain.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	public User getUser(String userId) {
		return getSqlSession().selectOne("com.example.demo.mapper.UserMapper.getUser", userId);
	}

}
