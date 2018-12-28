package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.AuthenticationDao;
import com.niit.BackendProject.Model.Authentication;

public class AuthenticationTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Authentication auth=(Authentication)ctx.getBean("authentication");
		AuthenticationDao authDao=(AuthenticationDao)ctx.getBean("authenticationDao");
		
		auth.setAuth_Id("a101");
		auth.setUserName("Padmavathi");
		
		if(authDao.saveorupdate(auth)==true)
		{
			System.out.println("Authentication details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		auth.setAuth_Id("a102");
		auth.setUserName("Padma");
		
		if(authDao.saveorupdate(auth)==true)
		{
			System.out.println("Authentication details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		auth.setAuth_Id("a103");
		auth.setUserName("Jaya");
		
		if(authDao.saveorupdate(auth)==true)
		{
			System.out.println("Authentication details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		auth.setAuth_Id("a104");
		auth.setUserName("Rani");
		
		if(authDao.saveorupdate(auth)==true)
		{
			System.out.println("Authentication details saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		auth=authDao.getAuthentication("a101");
		if(auth==null)
		{
			System.out.println("Auth details not exixts");
		}
		else
		{
			System.out.println("Auth Details");
			System.out.println(auth.getAuth_Id());
			System.out.println(auth.getRoleName());
			System.out.println(auth.getUserName());
		}
		
		auth=authDao.getAuthentication("a103");
		if(auth==null)
		{
			System.out.println("Auth details not exixts");
		}
		else
		{
			System.out.println("Auth details Deleting");
			if(authDao.delete(auth)==true)
			{
				System.out.println("Auth details Deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		
		List<Authentication> authList=authDao.authList();
		if(authList.isEmpty() || authList==null)
		{
			System.out.println("Auth details not exixts");
		}
		else
		{
			for(Authentication a:authList)
			{
				System.out.println(a.getAuth_Id());
				System.out.println(a.getRoleName());
				System.out.println(a.getUserName());
			}
		}
		ctx.close();
	}
}
