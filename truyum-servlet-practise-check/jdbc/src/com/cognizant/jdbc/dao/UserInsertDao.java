package com.cognizant.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cognizant.jdbc.model.User;

public class UserInsertDao {
	public static final String ADD_USER="insert into user(name,date_of_joining,salary,phone_number) values(?,?,?,?)";
	
	public  void insertUserDetails(User user) {
		Connection connection = ConnectionHandler.getDbConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(ADD_USER);
			statement.setString(1,  user.getName());
			statement.setDate(2, new java.sql.Date(user.getDateOfJoining().getTime()));
			statement.setDouble(3, user.getSalary());
			statement.setLong(4, user.getPhoneNumber());
			
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of rows affected "+noOfRows);
		} catch (SQLException e) {
			System.out.println("Data Not Inserted");
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
}
