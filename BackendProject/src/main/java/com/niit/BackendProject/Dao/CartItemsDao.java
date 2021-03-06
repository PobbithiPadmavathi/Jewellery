package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.CartItems;

public interface CartItemsDao 
{
	public boolean saveorupdate(CartItems cartItems);
	public boolean delete(String cartItemId);
	public CartItems getCartItems(String cartItemId);
	public List<CartItems> cartItemsList();
	public List<CartItems> getCartItemsList(String cartId);
	public CartItems get(String id);
	public CartItems getlistall(String cartId, String prodId);
	
	
}
