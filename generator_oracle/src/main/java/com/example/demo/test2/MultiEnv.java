package com.example.demo.test2;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.mapping.UserInfo;

public class MultiEnv {
	public static void main(String[] args) throws IOException {
		String configFile = "mybatis-config-multi-env.xml";
		InputStream configStream = Resources.getResourceAsStream(configFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession session = factory.openSession();
		
		
		UserInfo userinfo =	session.selectOne("selectById", 1070L);		  
	 
		
		System.out.println(
						userinfo.getId() + " " + 
						userinfo.getUsername() + " " +
						userinfo.getPassword() + " " +
						userinfo.getAge() + " " + 
						userinfo.getInsertdate());
		session.commit();
		session.close();
	}
}
