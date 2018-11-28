package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.BillingDao;
import com.niit.BackendProject.Model.Billing;

public class BillingTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billDao=(BillingDao)ctx.getBean("billingDao");
		
		bill.setBillId("B1");
		bill.setBillName("abc");
		bill.setAddress("Big Bazar");
		bill.setPhNo("9876523456");
		
		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Bill details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		bill.setBillId("B2");
		bill.setBillName("def");
		bill.setAddress("More");
		bill.setPhNo("9765423196");
		
		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Bill details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		bill.setBillId("B3");
		bill.setBillName("ghi");
		bill.setAddress("Big Deal");
		bill.setPhNo("8096790823");
		
		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Bill details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		bill=billDao.getBilling("s1");
		if(bill==null)
		{
			System.out.println("Bill not exists");
		}
		else
		{
			System.out.println("Bill Details...");
			System.out.println(bill.getBillId());
			System.out.println(bill.getBillName());
			System.out.println(bill.getAddress());
			System.out.println(bill.getPhNo());
		}
		
		bill=billDao.getBilling("s3");
		if(bill==null)
		{
			System.out.println("Bill not exists");
		}
		else
		{
			System.out.println("Billing details deleting...");
			if(billDao.delete(bill)==true)
			{
				System.out.println("Billing details deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		
		List<Billing> billList=billDao.billList();
		if(billList.isEmpty() || billList==null)
		{
			System.out.println("Billing details not exists");
		}
		else
		{
			for(Billing b:billList)
			{
				System.out.println(b.getBillId());
				System.out.println(b.getBillName());
				System.out.println(b.getAddress());
				System.out.println(b.getPhNo());
			}
		}
		ctx.close();
				
	}
}
