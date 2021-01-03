package com.example.demo.test3;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.cust.UserMapper;
import com.example.demo.tools.GetSqlSession;

public class UpdateUserinfoById {

	public static void main(String[] args) throws IOException {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", 41070L);
		map1.put("username", "xxxxx");
		map1.put("password", null);
		map1.put("age", 999);
		map1.put("insertdate", new Date());

		SqlSession session = GetSqlSession.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.updateUserinfoById(map1);
		session.commit();
		session.close();
	}

}
