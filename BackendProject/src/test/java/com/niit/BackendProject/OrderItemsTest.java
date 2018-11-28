package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.OrderItemsDao;
import com.niit.BackendProject.Model.OrderItems;

public class OrderItemsTest
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		OrderItems orderItems=(OrderItems)ctx.getBean("orderItems");
		OrderItemsDao orderItemsDao=(OrderItemsDao)ctx.getBean("orderItemsDao");
		
		orderItems.setOrderItemId("ot1");
		orderItems.setPrice(45000.00);
		if(orderItemsDao.saveorupdate(orderItems)==true)
		{
			System.out.println("OrderItems  Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		orderItems.setOrderItemId("ot2");
		orderItems.setPrice(65000.00);
		if(orderItemsDao.saveorupdate(orderItems)==true)
		{
			System.out.println("Order Item Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		orderItems.setOrderItemId("ot3");
		orderItems.setPrice(95000.00);
		if(orderItemsDao.saveorupdate(orderItems)==true)
		{
			System.out.println("Order Item Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		orderItems=orderItemsDao.getOrderItems("ot2");
		if(orderItems==null)
		{
			System.out.println("Order Item details not exists");
		}
		else
		{
			System.out.println("Order Items Details...");
			System.out.println(orderItems.getOrderItemId());
			System.out.println(orderItems.getPrice());
			
		}
		
		orderItems=orderItemsDao.getOrderItems("ot2");
		if(orderItems==null)
		{
			System.out.println("Order Item details not exists");
		}
		else
		{
			System.out.println("Order Items Details Deleting...");
			if(orderItemsDao.delete(orderItems)==true)
			{
				System.out.println("Order details deleted");
			}
			else
			{
				System.out.println("not deleted");
			}
		}
		
		List<OrderItems> orderItemsList=orderItemsDao.orderItemsList();
		if(orderItemsList.isEmpty() || orderItemsList==null)
		{
			System.out.println("Order Items list not exists");
		}
		else
		{
			for(OrderItems ot:orderItemsList)
			{
				System.out.println(ot.getOrderItemId());
				System.out.println(ot.getPrice());
			}
		}
		ctx.close();

	}
}
