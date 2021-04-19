package test1.copy.copy;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.DBTools;

public class Insert1 {
	public static void main(String[] args) throws IOException {

		// ### Error updating database. Cause:
		// java.lang.IllegalArgumentException: Mapped Statements collection does
		// not contain value for insert1

		UserInfo userinfo = new UserInfo();
		userinfo.setUsername("美国");
		userinfo.setPassword("200");
		userinfo.setAge(100l);
		userinfo.setInsertdate(new Date());

		SqlSession session = DBTools.getSqlSession();
		session.insert("insert1", userinfo);
		session.commit();
		session.close();

		System.out.println(userinfo.getId());
	}
}
