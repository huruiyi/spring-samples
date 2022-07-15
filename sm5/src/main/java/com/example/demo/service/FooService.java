package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;

@Transactional
public interface FooService {
	User doSomeBusinessStuff(String userId);
}
