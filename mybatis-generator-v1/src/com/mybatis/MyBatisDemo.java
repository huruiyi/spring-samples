package com.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.mapper.CountryMapper;
import com.example.model.Country;

public class MyBatisDemo {

	public static void main(String[] args) {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			inputStream.close();

			SqlSession sqlSession = sqlSessionFactory.openSession();
			CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
			Country country = mapper.selectByPrimaryKey(1);
			System.out.println(country.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
