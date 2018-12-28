package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.OrderDao;
import com.niit.BackendProject.Model.Order;

public class OrderTest
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Order order=(Order)ctx.getBean("order");
		OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
		
		order.setOrderId("o1");
		order.setGrand_Total(50000.00);
		order.setTotal_Items(2);
		if(orderDao.saveorupdate(order)==true)
		{
			System.out.println("Order Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		order.setOrderId("o2");
		order.setGrand_Total(100000.00);
		order.setTotal_Items(4);
		if(orderDao.saveorupdate(order)==true)
		{
			System.out.println("Order Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}

		order.setOrderId("o3");
		order.setGrand_Total(90000.00);
		order.setTotal_Items(2);
		if(orderDao.saveorupdate(order)==true)
		{
			System.out.println("Order Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		order=orderDao.getOrder("o2");
		if(order==null)
		{
			System.out.println("Order details not exists");
		}
		else
		{
			System.out.println("Order Details...");
			System.out.println(order.getOrderId());
			System.out.println(order.getGrand_Total());
			System.out.println(order.getTotal_Items());
		}
		
		order=orderDao.getOrder("o2");
		if(order==null)
		{
			System.out.println("Order details not exists");
		}
		else
		{
			System.out.println("Order Details Deleting...");
			if(orderDao.delete(order)==true)
			{
				System.out.println("Order details deleted");
			}
			else
			{
				System.out.println("not deleted");
			}
		}
		
		List<Order> orderList=orderDao.orderList();
		if(orderList.isEmpty() || orderList==null)
		{
			System.out.println("Order list not exists");
		}
		else
		{
			for(Order o:orderList)
			{
				System.out.println(o.getOrderId());
				System.out.println(o.getGrand_Total());
				System.out.println(o.getTotal_Items());
			}
		}
		ctx.close();

	}
}
