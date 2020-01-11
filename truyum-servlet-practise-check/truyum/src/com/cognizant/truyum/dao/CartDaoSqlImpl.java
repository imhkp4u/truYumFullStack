package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	public static final String ADD_MENUITEM_TO_CART = "insert into cart(ct_us_id,ct_me_id) values(?,?)";
	public static final String GET_MENUITEM_FROM_CART = "select * from menu_item m inner join cart c on m.me_id=c.ct_me_id where c.ct_us_id= ?";
	public static final String GET_TOTAL_FROM_CART = "select sum(m.me_price) as Total from menu_item m inner join cart c on m.me_id=c.ct_me_id where c.ct_us_id= ?";
	public static final String DELETE_FROM_CART = "delete  from cart where ct_us_id=? and ct_me_id=? limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		Cart cartItem = new Cart();
		PreparedStatement getMenuItemfromCart = null;
		PreparedStatement getTotal = null;
		ResultSet resultSetGetMenuItem = null;
		ResultSet resultSetGetTotal = null;
		MenuItem menuItem = null;
		try {
			getMenuItemfromCart = connection.prepareStatement(GET_MENUITEM_FROM_CART);
			getMenuItemfromCart.setLong(1, userId);
			resultSetGetMenuItem = getMenuItemfromCart.executeQuery();
			while (resultSetGetMenuItem.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSetGetMenuItem.getLong("me_id"));
				menuItem.setTitle(resultSetGetMenuItem.getString("me_name"));
				menuItem.setPrice(resultSetGetMenuItem.getFloat("me_price"));
				menuItem.setActive(resultSetGetMenuItem.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSetGetMenuItem.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSetGetMenuItem.getString("me_category"));
				menuItem.setFreeDelivery(resultSetGetMenuItem.getString("me_free_delivery").equals("1"));
				menuItemList.add(menuItem);
			}

			cartItem.setMenuItemList(menuItemList);
			getTotal = connection.prepareStatement(GET_TOTAL_FROM_CART);
			getTotal.setLong(1, userId);
			resultSetGetTotal = getTotal.executeQuery();
			if (menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			while (resultSetGetTotal.next()) {
				cartItem.setTotal(resultSetGetTotal.getDouble("Total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (getMenuItemfromCart != null)
					getMenuItemfromCart.close();
				if (getTotal != null)
					getTotal.close();
				if (resultSetGetMenuItem != null)
					resultSetGetMenuItem.close();
				if (resultSetGetTotal != null)
					resultSetGetTotal.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartItem;
	}

	@Override
	public void removeCartItem(long userID, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(DELETE_FROM_CART);
			preparedStatement.setLong(1, userID);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
