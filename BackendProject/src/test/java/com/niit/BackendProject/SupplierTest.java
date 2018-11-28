package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.SupplierDao;
import com.niit.BackendProject.Model.Supplier;

public class SupplierTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Supplier sup=(Supplier)ctx.getBean("supplier");
		SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");
		
		sup.setSupId("s1");
		sup.setSupName("Padmakar");
		sup.setAddress("Guntakal,AP");
		sup.setPhoneNo("+91 9494788819");
		
		if(supDao.saveorupdate(sup)==true)
		{
			System.out.println("Supplier dtails saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		sup.setSupId("s2");
		sup.setSupName("kiran");
		sup.setAddress("Bathinda,Punjab");
		sup.setPhoneNo("+91 8179330782");
		
		if(supDao.saveorupdate(sup)==true)
		{
			System.out.println("Supplier dtails saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		sup.setSupId("s3");
		sup.setSupName("Yaganti");
		sup.setAddress("Thirupathi,AP");
		sup.setPhoneNo("+91 9494788818");
		
		if(supDao.saveorupdate(sup)==true)
		{
			System.out.println("Supplier details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		sup=supDao.getSuplier("s2");
		if(sup==null)
		{
			System.out.println("Supplier not exists");
		}
		else
		{
			System.out.println(sup.getSupId());
			System.out.println(sup.getSupName());
			System.out.println(sup.getAddress());
			System.out.println(sup.getPhoneNo());
		}
		
		sup=supDao.getSuplier("s4");
		if(sup==null)
		{
			System.out.println("Supplier not exists");
		}
		else
		{
			System.out.println("Supplier Deleting");
			if(supDao.delete(sup)==true)
			{
				System.out.println("Supplier deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		
		List<Supplier> supList=supDao.supList();
		if(supList==null || supList.isEmpty())
		{
			System.out.println("Suppliers not exists");
		}
		else
		{
			for(Supplier s:supList)
			{
				System.out.println(s.getSupId());
				System.out.println(s.getSupName());
				System.out.println(s.getAddress());
				System.out.println(s.getPhoneNo());
			}
			
		}
		ctx.close();
	}
}
