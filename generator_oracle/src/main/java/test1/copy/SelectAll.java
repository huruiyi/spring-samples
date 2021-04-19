package test1.copy;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.DBTools;

public class SelectAll {
	public static void main(String[] args) throws IOException {
		SqlSession session = DBTools.getSqlSession();
		List<UserInfo> listUserinfo = session.selectList("selectAll");
		for (int i = 0; i < listUserinfo.size(); i++) {
			UserInfo userinfo = listUserinfo.get(i);
			System.out.println(userinfo.getId() + " " + userinfo.getUsername() + " " + userinfo.getPassword() + " "
					+ userinfo.getAge() + " " + userinfo.getInsertdate());
		}
		session.commit();
		session.close();
	}
}
