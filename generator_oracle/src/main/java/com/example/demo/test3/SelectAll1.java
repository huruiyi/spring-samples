package com.example.demo.test3;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.cust.UserMapper;
import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.GetSqlSession;

public class SelectAll1 {

	public static void main(String[] args) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "%中国%");
		map.put("password", "%中国人%");

		SqlSession session = GetSqlSession.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<UserInfo> listUserinfo = mapper.selectAll1(map);
		for (int i = 0; i < listUserinfo.size(); i++) {
			UserInfo userinfo = listUserinfo.get(i);
			System.out.println(userinfo.getId() + " " + userinfo.getUsername() + " " + userinfo.getPassword() + " " + userinfo.getAge() + " " + userinfo.getInsertdate());
		}
		session.commit();
		session.close();
	}

}
