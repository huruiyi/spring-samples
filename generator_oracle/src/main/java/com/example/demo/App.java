package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.mapping.UserInfo;
import com.example.demo.mapping.UserInfoMapper;

public class App {
	public static void main(String[] args) throws IOException {
		demo1();

		System.out.println("+++++++++++++++++++++++++++++++++");

		demo2();
	}

	static void demo1() throws IOException {
		String configFile = "mybatis-config.xml";
		InputStream configStream = Resources.getResourceAsStream(configFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		SqlSessionFactory factory = builder.build(configStream);
		System.out.println(factory);

		Configuration configuration = factory.getConfiguration();
		System.out.println(configuration);
	}

	static void demo2() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);

		int record1 = mapper.insert(getUserInfo());
		System.out.println(record1);

		int record2 = session.insert("insert", getUserInfo());
		System.out.println(record2);

		session.commit();
		session.close();
	}

	static UserInfo getUserInfo() {
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername("中国");
		userinfo.setPassword("中国人");
		userinfo.setAge(5000l);
		userinfo.setInsertdate(new Date());
		return userinfo;
	}
}
