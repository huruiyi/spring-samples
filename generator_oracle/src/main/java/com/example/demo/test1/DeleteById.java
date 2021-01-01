package com.example.demo.test1;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.tools.DBTools;

public class DeleteById {
	public static void main(String[] args) throws IOException {
		SqlSession session = DBTools.getSqlSession();
		session.delete("deleteById", 3L);
		session.commit();
		session.close();
	}
}
