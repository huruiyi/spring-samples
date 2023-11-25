package mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.mapper.CityMapper;
import mybatis.model.City;

public class MyBatisDemo {
	public static void main(String[] args) {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			inputStream.close();

			SqlSession sqlSession = sqlSessionFactory.openSession();
			CityMapper mapper = sqlSession.getMapper(CityMapper.class);
			City country = mapper.selectByPrimaryKey(1);
			System.out.println(country.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
