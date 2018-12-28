package com.niit.FrontendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BackendProject.Dao.UserDao;
import com.niit.BackendProject.Model.Cart;
import com.niit.BackendProject.Model.User;

@Controller
public class UserController 
{
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/user")
	public ModelAndView userform()
	{
		List<User> users=userDao.userList();
		ModelAndView obj=new ModelAndView("signup");
		obj.addObject("user", new User());
		obj.addObject("users", users);
		return obj;
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ModelAndView adduser(@ModelAttribute("user")User user)
	{
		ModelAndView obj= new ModelAndView("redirect:/user");
//		categoryDao.saveorupdate(category);
//		obj.addObject("echo", "Category is added successfully");
		Cart c= new Cart();
		c.setUser(user);
		user.setCart(c);
		if(userDao.saveorupdate(user)==true)
		{
			obj.addObject("echo", "User is added successfully");
			
		}
		else
		{
			obj.addObject("msg","Sorry! User is not added");
		}
	    obj.setViewName("redirect:/user");
		return obj;
	}

}
	

