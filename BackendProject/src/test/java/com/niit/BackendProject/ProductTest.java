package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.ProductDao;
import com.niit.BackendProject.Model.Product;


public class ProductTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Product prod=(Product)ctx.getBean("product");
		ProductDao prodDao=(ProductDao)ctx.getBean("productDao");
	
		prod.setProdId("p1001");
		prod.setProdName("Electic Kettle");
		prod.setQuantity(2);
		prod.setPrice(1500.00);
		prod.setDescription("Using to heat small items");
		
		if(prodDao.saveorupdate(prod)==true)
		{
			System.out.println("Product is saved");
		}
		else
		{
			System.out.println("Product nit saved");
		}
		
		prod.setProdId("p1002");
		prod.setProdName("Laptop");
		prod.setQuantity(5);
		prod.setPrice(200000.00);
		prod.setDescription("Laptops");
		
		if(prodDao.saveorupdate(prod)==true)
		{
			System.out.println("Product is saved");
		}
		else
		{
			System.out.println("Product nit saved");
		}
		
		prod.setProdId("p1003");
		prod.setProdName("iphone");
		prod.setQuantity(1);
		prod.setPrice(70000.00);
		prod.setDescription("New Style and new Look");
		
		if(prodDao.saveorupdate(prod)==true)
		{
			System.out.println("Product is saved");
		}
		else
		{
			System.out.println("Product nit saved");
		}
		
		
		prod=prodDao.getProd("p1002");
		if(prod==null)
		{
			System.out.println("Product not exists");
		}
		else
		{
			System.out.println("Product exists");
			System.out.println(prod.getProdId());
			System.out.println(prod.getProdName());
			System.out.println(prod.getQuantity());
			System.out.println(prod.getPrice());
			System.out.println(prod.getDescription());
		}
		
		prod=prodDao.getProd("p1004");
		if(prod==null)
		{
			System.out.println("Product not exists");		
		}
		else
		{
			System.out.println("Product Deleting...");
			if(prodDao.delete(prod)==true)
			{
				System.out.println("Confirm deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		
		List<Product> prodList=prodDao.prodList();
		if(prodList.isEmpty() || prodList==null)
		{
			System.out.println("Categories not existing");
		}
		else
		{
			for(Product p:prodList)
			{
				System.out.println(p.getProdId());
				System.out.println(p.getProdName());
				System.out.println(p.getQuantity());
				System.out.println(p.getPrice());
				System.out.println(p.getDescription());
			}
		}
		ctx.close();
		
	}
}
