package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {
	public static void main(String args[]) throws CartEmptyException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(1L, 2L);
		System.out.println("User Added Cart List for CheckOut");
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		Cart cart = cartDaoSqlImpl.getAllCartItems(1l);
		System.out.println(cart.getMenuItemList());
		System.out.println(cart.getTotal());
	}

	public static void testRemoveCartItem() {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartItem(1L, 2L);
		System.out.println("MenuItem removed from cart successfully");
	}
}
