package com.example.demo.cust;

import com.example.demo.mapping.UserInfo;

public interface UserMapper {

	public void insertUserInfo2(UserInfo userInfo);

	public UserInfo selectById(long userId);

}
