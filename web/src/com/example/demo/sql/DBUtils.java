package com.example.demo.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class DBUtils {
	static String Driver;
 	static String Url;
 	static String User;
 	static String Password;
 	static String Url_init;
 	static String sqlFile;
	
	
	static {
		Properties prop = null;
		try {
			prop = Resources.getResourceAsProperties("com/me/utils/db.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 获取配置信息
		Driver = prop.getProperty("jdbc.driver");
		Url = prop.getProperty("jdbc.url");
		User = prop.getProperty("jdbc.username");
		Password = prop.getProperty("jdbc.password");
		sqlFile = prop.getProperty("sqlFile");
		
		// 获取初始化数据库的Url
		if(Url.length()!=0){
			getInitUrl();
		}else{
			System.out.println("获取不到数据库连接地址Url");
		}
		
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 用来获取数据库连接
	 * @return
	 */
	public static Connection getCon(){
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(Url, User, Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
    /**
	 * 获取初始化数据库的连接
	 * @param url_init
	 * @return
	 */
	public static Connection getInitCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(Url_init, User, Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//  拼接数据库初始化连接Url
	private static String getInitUrl(){
		Url_init=Url.substring(0,Url.lastIndexOf("/")+1)+"mysql?useSSL=false";
		return Url_init;
	}

}
