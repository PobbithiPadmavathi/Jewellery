package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.OrderItems;

public interface OrderItemsDao 
{
	public boolean saveorupdate(OrderItems orderItems);
	public boolean delete(OrderItems orderItems);
	public OrderItems getOrderItems(String orderItemId);
	public List<OrderItems> orderItemsList();
}
