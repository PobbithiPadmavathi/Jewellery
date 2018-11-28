package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.CartItemsDao;
import com.niit.BackendProject.Model.CartItems;



public class CartItemsTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		CartItems cartItems=(CartItems)ctx.getBean("cartItems");
		CartItemsDao cartItemsDao=(CartItemsDao)ctx.getBean("cartItemsDao");
		
		cartItems.setCartItemId("ct101");
		cartItems.setPrice(25000.00);
		if(cartItemsDao.saveorupdate(cartItems)==true)
		{
			System.out.println("Cart Deatils are saved");
		}
		else 
		{
			System.out.println("Not saved");
		}
		
		cartItems.setCartItemId("ct102");
		cartItems.setPrice(50000.00);
		if(cartItemsDao.saveorupdate(cartItems)==true)
		{
			System.out.println("Cart Deatils are saved");
		}
		else 
		{
			System.out.println("Not saved");
		}
		
		cartItems.setCartItemId("ct103");
		cartItems.setPrice(100000.00);
		if(cartItemsDao.saveorupdate(cartItems)==true)
		{
			System.out.println("Cart Deatils are saved");
		}
		else 
		{
			System.out.println("Not saved");
		}
		
		cartItems.setCartItemId("ct104");
		cartItems.setPrice(94000.00);
		if(cartItemsDao.saveorupdate(cartItems)==true)
		{
			System.out.println("Cart Deatils are saved");
		}
		else 
		{
			System.out.println("Not saved");
		}
		
		cartItems=cartItemsDao.getCartItems("ct101");
		if(cartItems==null)
		{
			System.out.println("CartItems Details not exists");
		}
		else
		{
			System.out.println("Cart Details...");
			System.out.println(cartItems.getCartItemId());
			System.out.println(cartItems.getPrice());
			
		}
		
		cartItems=cartItemsDao.getCartItems("ct102");
		if(cartItems==null)
		{
			System.out.println("CartItems Details not exists");
		}
		else
		{
			System.out.println("CartItems Details Deleting...");
			if(cartItemsDao.delete(cartItems)==true)
			{
				System.out.println("CartItems Details Deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		
		List<CartItems> cartItemsList=cartItemsDao.cartItemsList();
		if(cartItemsList.isEmpty() || cartItemsList==null)
		{
			System.out.println("Cart Details not exists");
		}
		else
		{
			for(CartItems c:cartItemsList)
			{
				System.out.println(c.getCartItemId());
				System.out.println(c.getPrice());
			}
		}
		ctx.close();
	}
}
