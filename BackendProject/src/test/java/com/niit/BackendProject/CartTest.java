package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.CartDao;
import com.niit.BackendProject.Dao.UserDao;
import com.niit.BackendProject.Model.Cart;
import com.niit.BackendProject.Model.User;

public class CartTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Cart cart=(Cart)ctx.getBean("cart");
		CartDao cartDao=(CartDao)ctx.getBean("cartDao");
		
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		cart.setCartId("c11");
		cart.setTotalItems(2);
		cart.setGrandTotal(50000.00);
		
		user=userDao.getUser("u2");
		cart.setUser(user);
		
		if(cartDao.saveorupdate(cart)==true)
		{
			System.out.println("Cart Deatils are saved");
		}
		else 
		{
			System.out.println("Not saved");
		}
		
		cart.setCartId("c12");
		cart.setTotalItems(2);
		cart.setGrandTotal(80000.00);
		
		if(cartDao.saveorupdate(cart)==true)
		{
			System.out.println("Cart Deatils are saved");
		}
		else 
		{
			System.out.println("Not saved");
		}
		
		cart.setCartId("c13");
		cart.setTotalItems(4);
		cart.setGrandTotal(100000.00);
		
		if(cartDao.saveorupdate(cart)==true)
		{
			System.out.println("Cart Deatils are saved");
		}
		else 
		{
			System.out.println("Not saved");
		}
		
		cart.setCartId("c14");
		cart.setTotalItems(1);
		cart.setGrandTotal(1700000.00);
		
		if(cartDao.saveorupdate(cart)==true)
		{
			System.out.println("Cart Deatils are saved");
		}
		else 
		{
			System.out.println("Not saved");
		}
		
		cart=cartDao.getCart("c14");
		if(cart==null)
		{
			System.out.println("Cart Details not exists");
		}
		else
		{
			System.out.println("Cart Details...");
			System.out.println(cart.getCartId());
			System.out.println(cart.getTotalItems());
			System.out.println(cart.getGrandTotal());
		}
		
		cart=cartDao.getCart("c12");
		if(cart==null)
		{
			System.out.println("Cart Details not exists");
		}
		else
		{
			System.out.println("Cart Details Deleting...");
			if(cartDao.delete(cart)==true)
			{
				System.out.println("Cart Details Deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		
		List<Cart> cartList=cartDao.cartList();
		if(cartList.isEmpty() || cartList==null)
		{
			System.out.println("Cart Details not exists");
		}
		else
		{
			for(Cart c:cartList)
			{
				System.out.println(c.getCartId());
				System.out.println(c.getTotalItems());
				System.out.println(c.getGrandTotal());
			}
		}
		ctx.close();
	}
}
