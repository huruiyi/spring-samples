package com.example.demo.test2;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.tools.DBOperate;
import com.example.demo.tools.GetSqlSession;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class UpdateById {
	public static void main(String[] args) throws IOException {
		try {
			Map<String, Long> queryMap = new HashMap();
			queryMap.put("userId", 1058L);

			DBOperate dbo = new DBOperate();
			List<Map> listMap = dbo.select("selectByIdToMap", queryMap);
			if (listMap.size() == 1) {
				Map<String, Object> findMap = listMap.get(0);
				findMap.put("username", "u111111");
				findMap.put("password", "p111111");
				findMap.put("age", 999999L);
				findMap.put("insertdate", new Date());
				findMap.put("id", findMap.get("ID"));

				dbo.update("updateByIdMap", findMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally {
			GetSqlSession.commit();
		}
	}
}
