package com.cognizant.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.jdbc.model.Employee;

public class EmployeeDAO {
	public static final String ADD_EMPLOYEE = "insert into employee(employee_id,name,date_of_birth,salary) values(?,?,?,?)";
	public static final String EMPLOYEE_ALL_DETAILS = "select * from employee";

	public void addEmployee(Employee employee) throws SQLException {
		Connection connection = ConnectionHandler.getDbConnection();
		PreparedStatement statement = null;

		statement = connection.prepareStatement(ADD_EMPLOYEE);
		statement.setInt(1, employee.getEmployeeId());
		statement.setString(2, employee.getName());
		statement.setDate(3, new java.sql.Date(employee.getDateOfBirth().getTime()));
		statement.setDouble(4, employee.getSalary());

		int noOfRows = statement.executeUpdate();
		System.out.println(
				"Number of rows affected " + noOfRows + "\nThe Given data is successfully inserted to the database.");

		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employeeList = new ArrayList<>();
		Connection connection = ConnectionHandler.getDbConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(EMPLOYEE_ALL_DETAILS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("employee_id"));
				employee.setName(resultSet.getString("name"));
				employee.setDateOfBirth(resultSet.getDate("date_of_birth"));
				employee.setSalary(resultSet.getDouble("salary"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return employeeList;
	}
}
