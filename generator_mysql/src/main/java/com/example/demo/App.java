package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.mapping.UserInfo;
import com.example.demo.mapping.UserInfoMapper;

public class App {
	public static void main(String[] args) throws IOException {
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername("中国");
		userinfo.setPassword("中国人");
		userinfo.setAge(100);
		userinfo.setInsertdate(new Date());

		String configFile = "mybatis-config.xml";
		InputStream configStream = Resources.getResourceAsStream(configFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession session = factory.openSession();

		session.insert("insert", userinfo);

		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
		mapper.insert(userinfo);

		session.commit();
		session.close();
	}
}
