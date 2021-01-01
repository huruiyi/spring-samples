package com.example.demo.test2;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.tools.DBOperate;
import com.example.demo.tools.GetSqlSession;

public class Insert1 {
	public static void main(String[] args) throws IOException {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("username", "毛泽东");
			map.put("password", "1200");
			map.put("age", 120L);
			map.put("insertdate", new Date());

			DBOperate dbo = new DBOperate();
			dbo.save("insertUserinfo", map);
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally {
			GetSqlSession.commit();
		}
	}
}
