package com.cognizant.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateDao {
	public static final String UPDATE_USER = "update user set salary = salary+1000 where id=?";
	
	public boolean updateUserDetails(int userId) {
		Connection connection = ConnectionHandler.getDbConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_USER);
			statement.setInt(1, userId);
			int noOfRows = statement.executeUpdate();
			if(noOfRows > 0) {
				return true;
			}
			else
				System.out.println("No such id exists!");
		} catch (SQLException e) {
			System.out.println("Update not found");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return false;
	}
}
