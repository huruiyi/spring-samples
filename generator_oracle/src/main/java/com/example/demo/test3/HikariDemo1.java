package com.example.demo.test3;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.cust.UserMapper;
import com.example.demo.mapping.UserInfo;

public class HikariDemo1 {
	public static void main(String[] args) throws IOException, SQLException {

		Reader reader = Resources.getResourceAsReader("config/mybatis-config-hikari.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		UserMapper mapper = session.getMapper(UserMapper.class);

		UserInfo userinfo1 = mapper.selectById(41052);
		UserInfo userinfo2 = mapper.selectById(41054);
		UserInfo userinfo3 = mapper.selectById(41056);
		UserInfo userinfo4 = mapper.selectById(41058);

		System.out.println(userinfo1.getId() + " " + userinfo1.getUsername());
		System.out.println(userinfo2.getId() + " " + userinfo1.getUsername());
		System.out.println(userinfo3.getId() + " " + userinfo1.getUsername());
		System.out.println(userinfo4.getId() + " " + userinfo1.getUsername());

		session.commit();
		session.close();

		DataSource ds = sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
		for (int i = 0; i < 15; i++) {
			Connection connection = ds.getConnection();
			System.out.println(connection);
			connection.close();
		}

	}
}
