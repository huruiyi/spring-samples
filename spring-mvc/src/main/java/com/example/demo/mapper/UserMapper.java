package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.po.User;

@Repository
public interface UserMapper {
	public User findUsersByUsername(String username);
	public int addUser(User user);
	public int modifyPasswordByUsername(User user);
}
