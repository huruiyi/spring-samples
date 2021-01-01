package com.example.demo.test2;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.tools.DBOperate;
import com.example.demo.tools.GetSqlSession;

public class Insert2 {
	public static void main(String[] args) throws IOException {
		try {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("username", "U1");
			map1.put("password", "u1pass");
			map1.put("age", 333L);
			map1.put("insertdate", new Date());

			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("username", "u2");
			map2.put("password", "u2pass");
			map2.put("age", 333L);
			map2.put("insertdate", new Date());

			DBOperate dbo = new DBOperate();
			dbo.save("insertUserinfo", map1);
			dbo.save("insertUserinfo", map2);

		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally {
			GetSqlSession.commit();
		}
	}
}
