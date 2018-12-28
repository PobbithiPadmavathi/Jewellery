package com.niit.FrontendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BackendProject.Dao.CategoryDao;
import com.niit.BackendProject.Dao.ProductDao;
import com.niit.BackendProject.Model.Category;
import com.niit.BackendProject.Model.Product;

@Controller
public class CategoryController {
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;

	@RequestMapping("/Category")
	public ModelAndView categoryform()
	{
		List<Category> categories=categoryDao.catList();
		ModelAndView obj = new ModelAndView("category");
		obj.addObject("category", new Category());
		obj.addObject("categories",categories);
		return obj;
	}
	
	@RequestMapping(value="/addcat", method=RequestMethod.POST)
	public ModelAndView addcat(@RequestParam("catId")String id, @RequestParam("catName")String name)
	{
		ModelAndView obj=new ModelAndView("redirect:/Category");
		category.setCatId(id);
		category.setCatName(name);
		if(categoryDao.saveorupdate(category)==true)
		{
			obj.addObject("msg", "Category Saved");
		}
		else
		{
			obj.addObject("msg", "Category Not saved");
		}
		return obj;
	}
	
	/*@RequestMapping(value="/addcategory", method=RequestMethod.POST)
	public ModelAndView addcategory(@ModelAttribute("category")Category category ) {
		ModelAndView obj = new ModelAndView("redirect:/Category");
		if(categoryDao.saveorupdate(category))
		{
	       obj.addObject("msg","category is added successfuly");  		
		}
		else
		{
			obj.addObject("msg","Sorry");
		}
		return obj;
	}*/
	
	@RequestMapping("/editcategory/{catId}")
	public ModelAndView edditcategory(@PathVariable("catId")String id)
	{
		System.out.println(123);
		List<Category> categories=categoryDao.catList();
		ModelAndView obj = new ModelAndView("category");
		category=categoryDao.getCategory(id);
		obj.addObject("categories",categories);
		obj.addObject("category",category);
		return obj;
		
	}
	
	@RequestMapping("/deletecategory/{catId}")
	public ModelAndView deletecategory(@PathVariable("catId")String catId)
	{
		ModelAndView obj=new ModelAndView("redirect:/Category");
		category=categoryDao.getCategory(catId);

//				List<Product> lists= (List<Product>) productDao.getProd("category");
//				if(lists==null||lists.isEmpty())
//				{	
					categoryDao.delete(category);
					obj.addObject("msg","category is deleted successfuly");
					return obj;			
				}
	
//				else
//				{
//					for(Product p: lists)
//					{
//						productDao.delete(p);
//					}
//					categoryDao.delete(category);
//					obj.addObject("msg","category and product is deleted successfuly");
//				}	
//				return obj;
//				}
	
}



	
	



	
	