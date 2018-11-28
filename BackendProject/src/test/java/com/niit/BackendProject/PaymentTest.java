package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.PaymentDao;
import com.niit.BackendProject.Model.Payment;

public class PaymentTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Payment payment=(Payment)ctx.getBean("payment");
		PaymentDao paymentDao=(PaymentDao)ctx.getBean("paymentDao");
		
		payment.setPayId("p1");
		payment.setMethod("Debit Card");
		payment.setStatus("Active");
		if(paymentDao.saveorupdate(payment)==true)
		{
			System.out.println("Payment Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		payment.setPayId("p2");
		payment.setMethod("NetBanking");
		payment.setStatus("Active");
		if(paymentDao.saveorupdate(payment)==true)
		{
			System.out.println("Payment Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		payment.setPayId("p3");
		payment.setMethod("Credit Card");
		payment.setStatus("Active");
		if(paymentDao.saveorupdate(payment)==true)
		{
			System.out.println("Payment Details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		payment=paymentDao.getPayment("p3");
		if(payment==null)
		{
			System.out.println("Payment details not exists");
		}
		else
		{
			System.out.println("Payment Details..");
			System.out.println(payment.getPayId());
			System.out.println(payment.getMethod());
			System.out.println(payment.getStatus());
		}
		payment=paymentDao.getPayment("p4");
		if(payment==null)
		{
			System.out.println("Payment details not exists");
		}
		else
		{
			System.out.println("Payment Details Deleting..");
			if(paymentDao.delete(payment)==true)
			{
				System.out.println("Payment details deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		List<Payment> payLists=paymentDao.payList();
		if(payLists.isEmpty() || payLists==null)
		{
			System.out.println("Payment List Details not exists");
		}
		else
		{
			for(Payment p:payLists)
			{
				System.out.println(p.getPayId());
				System.out.println(p.getMethod());
				System.out.println(p.getStatus());
			}
		}
		ctx.close();
	}
}
