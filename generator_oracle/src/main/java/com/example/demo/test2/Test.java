package com.example.demo.test2;

import java.io.IOException;

import com.example.demo.tools.GetSqlSession;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println(GetSqlSession.getSqlSession().hashCode());
		System.out.println(GetSqlSession.getSqlSession().hashCode());
		System.out.println(GetSqlSession.getSqlSession().hashCode());
		System.out.println(GetSqlSession.getSqlSession().hashCode());
		System.out.println(GetSqlSession.getSqlSession().hashCode());
		System.out.println(GetSqlSession.getSqlSession().hashCode());
		System.out.println(GetSqlSession.getSqlSession().hashCode());
	}
}
