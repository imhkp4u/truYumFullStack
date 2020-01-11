package com.cognizant.jdbc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.jdbc.dao.EmployeeDAO;
import com.cognizant.jdbc.model.Employee;

public class InsertEmployeeBO {

	public static void display(ArrayList<Employee> employeeList) {
		for (Employee emp : employeeList) {
			System.out.format("\n%10s%15s%10s", emp.getName(), emp.getDateOfBirth(), emp.getSalary());
		}
	}

	public static void main(String args[]) throws NumberFormatException, IOException, ParseException, SQLException {

		Employee employee = new Employee();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the Employee details\nEnter the ID:");
		employee.setEmployeeId(Integer.parseInt(bf.readLine()));

		System.out.println("Enter the Name:");
		employee.setName(bf.readLine());

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Enter the Date of birth (dd-MM-yyyy):");
		employee.setDateOfBirth(sdf.parse(bf.readLine()));

		System.out.println("Enter the Salary:");
		employee.setSalary(Double.parseDouble(bf.readLine()));

		new EmployeeDAO().addEmployee(employee);
		ArrayList<Employee> employeeList = new EmployeeDAO().getAllEmployees();
		display(employeeList);
	}

}
