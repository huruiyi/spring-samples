package test1.copy;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.DBTools;

public class Insert2 {
	public static void main(String[] args) throws IOException {

		UserInfo userinfo = new UserInfo();
		userinfo.setUsername("美国");
		userinfo.setPassword("300");
		userinfo.setAge(300L);
		userinfo.setInsertdate(new Date());

		SqlSession session = DBTools.getSqlSession();
		session.insert("insert2", userinfo);
		session.commit();
		session.close();

		System.out.println(userinfo.getId());
	}
}
