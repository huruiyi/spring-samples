package test1.copy;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.tools.DBTools;

public class NamespaceDemo {
	public static void main(String[] args) throws IOException {
		SqlSession session = DBTools.getSqlSession();

		int result1 = session.insert("A.insertUserinfo");
		int result2 = session.insert("B.insertUserinfo");
		System.out.println(result1);
		System.out.println(result2);

		session.commit();
		session.close();
	}
}
