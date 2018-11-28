package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.Order;

public interface OrderDao
{
	public boolean saveorupdate(Order order);
	public boolean delete(Order order);
	public Order getOrder(String orderId);
	public List<Order> orderList();
}
