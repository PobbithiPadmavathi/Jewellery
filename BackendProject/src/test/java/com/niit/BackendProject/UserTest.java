package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.UserDao;
import com.niit.BackendProject.Model.User;

public class UserTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		user.setUserId("u1");
		user.setUserName("Padmakar");
		user.setAddress("Guntakal,AP");
		user.setPhoneNo("+91 9494788819");
		user.setEmailIid("kksilverpadma1999@gmail.com");
		user.setPassword("silver1999");
		
		if(userDao.saveorupdate(user)==true)
		{
			System.out.println("User dtails saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		user.setUserId("u2");
		user.setUserName("kiran");
		user.setAddress("Bathinda,Punjab");
		user.setPhoneNo("+91 8179330782");
		user.setEmailIid("kkpadma1999@gmail.com");
		user.setPassword("padma1999");
		
		if(userDao.saveorupdate(user)==true)
		{
			System.out.println("User dtails saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		user.setUserId("u3");
		user.setUserName("Yaganti");
		user.setAddress("Banglore");
		user.setPhoneNo("+91 9179330781");
		user.setEmailIid("yaganti9@gmail.com");
		user.setPassword("yag@123");
		
		if(userDao.saveorupdate(user)==true)
		{
			System.out.println("User dtails saved");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		user=userDao.getUser("u2");
		if(user==null)
		{
			System.out.println("Supplier not exists");
		}
		else
		{
			System.out.println(user.getUserId());
			System.out.println(user.getUserName());
			System.out.println(user.getAddress());
			System.out.println(user.getPhoneNo());
			System.out.println(user.getEmailIid());
			System.out.println(user.getPassword());
		}
		
		user=userDao.getUser("u4");
		if(user==null)
		{
			System.out.println("User not exists");
		}
		else
		{
			System.out.println("User Deleting");
			if(userDao.delete(user)==true)
			{
				System.out.println("User deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		
		List<User> userList=userDao.userList();
		if(userList==null || userList.isEmpty())
		{
			System.out.println("Users not exists");
		}
		else
		{
			for(User u: userList)
			{
				System.out.println(u.getUserId());
				System.out.println(u.getUserName());
				System.out.println(u.getAddress());
				System.out.println(u.getPhoneNo());
				System.out.println(u.getEmailIid());
				System.out.println(u.getPassword());
			}
			
		}
		ctx.close();

	}
}
