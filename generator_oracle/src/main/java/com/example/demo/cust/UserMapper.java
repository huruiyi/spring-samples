package com.example.demo.cust;

import java.util.List;
import java.util.Map;

import com.example.demo.mapping.UserInfo;

@SuppressWarnings({ "rawtypes" })
public interface UserMapper {

	public void insertUserInfo2(UserInfo userInfo);

	public UserInfo selectById(long userId);

	public List<UserInfo> selectAll1(Map map);

	public List<UserInfo> selectAll2(Map map);

	public void updateUserinfoById(Map map);
}
