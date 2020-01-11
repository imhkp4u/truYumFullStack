package com.cognizant.truyum.dao;

import java.io.BufferedInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	static Connection getConnection() {
		BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("connection.properties");
		Properties prop = new Properties();
		try {
			prop.load(bufferedInputStream);
		} catch (Exception e) {
			System.out.println("Unable to load connection.properties file");
		}
		String driver = (String) prop.get("driver");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the mysql driver" + e.getMessage());
		}
		String user = (String) prop.get("user");
		String password = (String) prop.get("password");
		String connection_url = (String) prop.get("connection_url");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connection_url, user, password);
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
		}
		return connection;
	}
}
