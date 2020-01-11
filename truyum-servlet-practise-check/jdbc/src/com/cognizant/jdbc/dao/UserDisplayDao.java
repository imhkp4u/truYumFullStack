package com.cognizant.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.jdbc.model.User;
import java.sql.ResultSetMetaData;

public class UserDisplayDao {
	public static final String USER_ALL_DETAILS="select * from user";
	
	public ArrayList<User> getAllUserDetails(){
	    ArrayList<User> userList = new ArrayList<>();
		Connection connection = ConnectionHandler.getDbConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement=connection.prepareStatement(USER_ALL_DETAILS);
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			System.out.println("The column count is: "+metaData.getColumnCount());
			System.out.println("The column name is: "+metaData.getColumnName(1));
			System.out.println("The table name is: "+metaData.getTableName(1));
			while(resultSet.next()) {
				User user=new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setDateOfJoining(resultSet.getDate("date_of_joining"));
				user.setSalary(resultSet.getDouble("salary"));
				user.setPhoneNumber(resultSet.getLong("phone_number"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return userList;
	}
}
