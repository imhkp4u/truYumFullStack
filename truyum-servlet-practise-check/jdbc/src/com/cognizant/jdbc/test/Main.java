package com.cognizant.jdbc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.cognizant.jdbc.dao.UserDeleteDao;
import com.cognizant.jdbc.dao.UserDisplayDao;
import com.cognizant.jdbc.dao.UserInsertDao;
import com.cognizant.jdbc.dao.UserUpdateDao;
import com.cognizant.jdbc.model.User;

public class Main {
	private static Scanner sc;

	public static void display(ArrayList<User> list) {
		System.out.format("%15s%15s%10s%18s%14s","ID", "NAME", "DOJ", "SALARY", "PHONE");
		for(User us:list) {
			System.out.format("\n%15s%15s%15s%15s%15s", us.getId(), us.getName(), us.getDateOfJoining(), us.getSalary(), us.getPhoneNumber());
		}
	}
	
	public  static void main(String args[]) throws IOException, ParseException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		sc = new Scanner(System.in);
		System.out.println("Please select your choice:");
		while(true) {
		System.out.println("\n1. Press '1' for inserting data\n2. Press '2' for displaying data\n3. Press '3' for updating data\n4. Press '4' for deleting data\n5. Press '5' to exit");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			
			User user=new User();
			
			System.out.println("User name");
			user.setName(bf.readLine());
			
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("User Doj");
			user.setDateOfJoining(sdf.parse(bf.readLine()));
			
			System.out.println("User salary");
			user.setSalary(Double.parseDouble(bf.readLine()));
			
			System.out.println("User Phone Number");
			user.setPhoneNumber(Long.parseLong(bf.readLine()));
			
			new UserInsertDao().insertUserDetails(user);
			break;
		case 2:
			ArrayList<User> userList = new UserDisplayDao().getAllUserDetails();
			display(userList);
			break;
		case 3:
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter the id you want to update");
			int id=scan.nextInt();
			new UserUpdateDao().updateUserDetails(id);
			display(new UserDisplayDao().getAllUserDetails());
			
			break;
		case 4:
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the id you want to delete");
			int id1=s.nextInt();
			new UserDeleteDao().deleteUserDetails(id1);
			display( new UserDisplayDao().getAllUserDetails());
			
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid choice!");
		}
		}
	}
}
