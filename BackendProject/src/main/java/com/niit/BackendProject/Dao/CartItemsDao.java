package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.CartItems;

public interface CartItemsDao 
{
	public boolean saveorupdate(CartItems cartItems);
	public boolean delete(CartItems cartItems);
	public CartItems getCartItems(String cartItemId);
	public List<CartItems> cartItemsList();
}
