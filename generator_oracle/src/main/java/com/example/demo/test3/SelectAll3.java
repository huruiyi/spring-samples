package com.example.demo.test3;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.cust.UserMapper;
import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.GetSqlSession;

public class SelectAll3 {

	public static void main(String[] args) throws IOException {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("username", "%中国%");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("password", "%中国人%");

		Map<String, String> map3 = new HashMap<String, String>();

		SqlSession session = GetSqlSession.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<UserInfo> listUserinfo = mapper.selectAll2(map1);
		for (int i = 0; i < listUserinfo.size(); i++) {
			UserInfo userinfo = listUserinfo.get(i);
			System.out.println(userinfo.getId() + " " + userinfo.getUsername() + " " + userinfo.getPassword() + " " + userinfo.getAge() + " " + userinfo.getInsertdate());
		}
		System.out.println();
		listUserinfo = mapper.selectAll2(map2);
		for (int i = 0; i < listUserinfo.size(); i++) {
			UserInfo userinfo = listUserinfo.get(i);
			System.out.println(userinfo.getId() + " " + userinfo.getUsername() + " " + userinfo.getPassword() + " " + userinfo.getAge() + " " + userinfo.getInsertdate());
		}
		System.out.println();
		listUserinfo = mapper.selectAll2(map3);
		for (int i = 0; i < listUserinfo.size(); i++) {
			UserInfo userinfo = listUserinfo.get(i);
			System.out.println(userinfo.getId() + " " + userinfo.getUsername() + " " + userinfo.getPassword() + " " + userinfo.getAge() + " " + userinfo.getInsertdate());
		}
		session.commit();
		session.close();
	}

}
