package com.example.demo.test;

import java.io.IOException;
import java.util.Date;

import com.example.demo.mapping.UserInfo;
import org.apache.ibatis.session.SqlSession;

import com.example.demo.tools.DBTools;

public class Insert1 {
	public static void main(String[] args) throws IOException {
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername("中国");
		userinfo.setPassword("中国人");
		userinfo.setAge(5000);
		userinfo.setInsertdate(new Date());

		SqlSession session = DBTools.getSqlSession();
		session.insert("insert1", userinfo);
		session.commit();
		session.close();

		System.out.println(userinfo.getId());
	}
}
