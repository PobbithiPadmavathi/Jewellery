package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.ShippingDao;
import com.niit.BackendProject.Dao.UserDao;
import com.niit.BackendProject.Model.Shipping;
import com.niit.BackendProject.Model.User;

public class ShippingTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
		
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		ship.setShipId("Sh1");
		ship.setShipName("Vizag Port");
		ship.setAddress("Vizag,AP");
		ship.setPhno("7895437612");
		
		user=userDao.getUser("u2");
		ship.setUser(user);
		
		if(shipDao.saveorupdate(ship)==true)
		{
			System.out.println("Ship details are saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		ship.setShipId("Sh2");
		ship.setShipName("Vizayawada Port");
		ship.setAddress("Vizayawada,AP");
		ship.setPhno("8934761232");
		
		if(shipDao.saveorupdate(ship)==true)
		{
			System.out.println("Ship details are saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		ship.setShipId("Sh3");
		ship.setShipName("Rayalaseema Ship");
		ship.setAddress("Vizag Port,AP");
		ship.setPhno("6345892143");
		
		if(shipDao.saveorupdate(ship)==true)
		{
			System.out.println("Ship details are saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		ship=shipDao.getShipping("Sh3");
		if(ship==null)
		{
			System.out.println("Ship details not exists");
		}
		else
		{
			System.out.println("Ship Details");
			System.out.println(ship.getShipId());
			System.out.println(ship.getShipName());
			System.out.println(ship.getAddress());
			System.out.println(ship.getPhno());
		}
		
		ship=shipDao.getShipping("Sh3");
		if(ship==null)
		{
			System.out.println("Ship details not exists");
		}
		else
		{
			System.out.println("Ship Details deleting...");
			if(shipDao.delete(ship)==true)
			{
				System.out.println("Ship Details deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		
		List<Shipping> shipList=shipDao.shipList();
		if(shipList.isEmpty() || shipList==null)
		{
			System.out.println("Ship Details not exists");
		}
		else
		{
			for(Shipping s:shipList)
			{
				System.out.println(s.getShipId());
				System.out.println(s.getShipName());
				System.out.println(s.getAddress());
				System.out.println(s.getPhno());
			}
		}
		ctx.close();
		
	}
}
