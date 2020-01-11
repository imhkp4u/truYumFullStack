package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String args[]) throws SQLException {
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
		testGetMenuItemListAdmin();
	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(3L, "Sugarcane", 350.00f, true, new DateUtil().convertToDate("02/12/2022"),
				"Juice", true);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println("Menu Item List  modified successfully");
	}

	public static void testGetMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menuItemList = menuItemDao.getMenuItem(02l);
		System.out.println(menuItemList);
	}
}
