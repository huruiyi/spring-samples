package com.example.demo.sql;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

public class RunSqlScript extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 记得配置web.xml
	@Override
	public void init() throws ServletException {
		System.out.println("项目初始化开始，自动加载开始");
		// 初始化脚本
		run();
		System.out.println("项目初始化结束，自动加载结束");
	}

	// 数据库初始化脚本
	public void run() {
		System.out.println("======  数据库初始化START   ======");

		// https://blog.csdn.net/weixin_42191996/article/details/102992072

		Connection con = DBUtils.getInitCon();

		ScriptRunner runner = new ScriptRunner(con);
		runner.setErrorLogWriter(null);
		runner.setLogWriter(null);

		try {
			// mybatis 读取并执行sql文件
			String sqlFile = DBUtils.sqlFile;
			Reader reader = Resources.getResourceAsReader(sqlFile);
			runner.runScript(reader);
			con.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("====== 数据库初始化SUCCESS  ======");
	}

}
