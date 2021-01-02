package com.example.demo.test3;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.cust.UserMapper;
import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.GetSqlSessionBatch;

public class BatchInsert2 {
	public static void main(String[] args) throws IOException {
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername("中国");
		userinfo.setPassword("中国人");
		userinfo.setAge(100L);
		userinfo.setInsertdate(new Date());

		SqlSession session = GetSqlSessionBatch.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			mapper.insertUserInfo2(userinfo);
		}
		long endTime = System.currentTimeMillis();
		session.commit();
		session.close();
		System.out.println(endTime - beginTime);
	}
}
