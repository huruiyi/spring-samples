package com.example.demo.test2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.tools.DBOperate;
import com.example.demo.tools.GetSqlSession;

public class DeleteById {
	public static void main(String[] args) throws IOException {
		try {
			Map<String, Long> queryMap = new HashMap<String, Long>();
			queryMap.put("userId", 1056L);

			DBOperate dbo = new DBOperate();
			dbo.delete("deleteById", queryMap);
			System.out.println("delete ok");
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
			System.out.println("delete not ok");
		} finally {
			GetSqlSession.commit();
		}
	}
}
