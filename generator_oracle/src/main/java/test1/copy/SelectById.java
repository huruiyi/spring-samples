package test1.copy;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.DBTools;

public class SelectById {
	public static void main(String[] args) throws IOException {
		SqlSession session = DBTools.getSqlSession();
		UserInfo userinfo = session.selectOne("selectById", 1056L);
		System.out.println(userinfo.getId() + " " + userinfo.getUsername() + " " + userinfo.getPassword() + " "
				+ userinfo.getAge() + " " + userinfo.getInsertdate());
		session.commit();
		session.close();
	}
}
