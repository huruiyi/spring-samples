package com.example.demo.test1;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.DBTools;

public class UpdateById {
	public static void main(String[] args) throws IOException {
		SqlSession session = DBTools.getSqlSession();
		UserInfo userinfo = session.selectOne("selectById", 1056L);
		userinfo.setUsername("xxxxxx");
		userinfo.setPassword("xxxxxxxxxxxxx");
		userinfo.setAge(200L);
		session.update("updateById", userinfo);
		session.commit();
		session.close();
	}
}
