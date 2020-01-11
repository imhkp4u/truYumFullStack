package com.cognizant.jdbc.dao;

import java.io.BufferedInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	static Connection getDbConnection() {
		// read the property from property file -> db.properties
		BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("db.properties");
		Properties prop = new Properties();
		try {
			prop.load(bufferedInputStream);
		} catch (Exception e) {
			System.out.println("Unable to load db.Properties file");
		}
		String driver = (String) prop.get("driver");
		// System.out.println("Driver name-> " + driver);
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the mysql driver" + e.getMessage());
		}
		String user = (String) prop.get("user");
		String password = (String) prop.get("password");
		String url = (String) prop.get("url");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
		}
		return connection;
	}
}
