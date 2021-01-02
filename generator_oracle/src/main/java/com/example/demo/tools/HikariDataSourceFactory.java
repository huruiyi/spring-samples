package com.example.demo.tools;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceFactory implements DataSourceFactory {

	private Properties prop;

	public DataSource getDataSource() {
		HikariDataSource ds = new HikariDataSource();
		String driver = prop.getProperty("driver");
		System.out.println(driver);

		ds.setDriverClassName(prop.getProperty("driver"));
		ds.setUsername(prop.getProperty("username"));
		ds.setPassword(prop.getProperty("password"));
		ds.setJdbcUrl(prop.getProperty("url"));

		ds.setMaximumPoolSize(10);
		ds.setMinimumIdle(10);

		return ds;
	}

	public void setProperties(Properties arg0) {
		prop = arg0;
	}

}
