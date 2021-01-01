package com.example.demo.test2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.demo.tools.DBOperate;
import com.example.demo.tools.GetSqlSession;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SelectAll {
	public static void main(String[] args) throws IOException {
		try {
			DBOperate dbo = new DBOperate();
			List<Map> listMap = dbo.select("selectAllToMap", null);
			for (int i = 0; i < listMap.size(); i++) {
				Map<?, ?> map = listMap.get(i);
				Object id = map.get("ID");
				Object username = map.get("USERNAME");
				Object password = map.get("PASSWORD");
				Object age = map.get("AGE");
				Object insertdate = map.get("INSERTDATE");
				System.out.println(id + " " + username + " " + password + " " + age + " " + insertdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally {
			GetSqlSession.commit();
		}
	}
}
