package com.cognizant.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteDao {
	public static final String DELETE_USER = "delete from user where id=?";

	public boolean deleteUserDetails(int userId) {
		Connection connection = ConnectionHandler.getDbConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DELETE_USER);
			statement.setInt(1, userId);
			int noOfRows = statement.executeUpdate();
			if (noOfRows > 0) {
				return true;
			}
			else
				System.out.println("No such id exists!");
		} catch (SQLException e) {
			System.out.println("None of the rows got deleted");
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
