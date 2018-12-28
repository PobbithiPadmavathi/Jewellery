package com.niit.FrontendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BackendProject.Dao.CategoryDao;
import com.niit.BackendProject.Dao.ProductDao;
import com.niit.BackendProject.Dao.SupplierDao;
import com.niit.BackendProject.Model.Category;
import com.niit.BackendProject.Model.Product;
import com.niit.BackendProject.Model.Supplier;



@Controller
public class SupplierController
{
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/Supplier")
	public ModelAndView supplierForm()
	{
		List<Supplier> suppliers=supplierDao.supList();
		ModelAndView obj=new ModelAndView("supplier");
		obj.addObject("supplier", new Supplier());
		obj.addObject("suppliers", suppliers);
		return obj;
	}
	
	@RequestMapping(value="/addsupplier",method=RequestMethod.POST)
	public ModelAndView addsupplier(@ModelAttribute("supplier")Supplier supplier)
	{
		ModelAndView obj= new ModelAndView();
//   	categoryDao.saveorupdate(category);
//		obj.addObject("echo", "Category is adds successfully");
		if(supplierDao.saveorupdate(supplier)==true)
		{
			obj.addObject("echo", "Supplier is added successfully");
			
		}
		else
		{
			obj.addObject("msg","Sorry! Supplier is not added");
		}
		obj.setViewName("redirect:/Supplier");
		return obj;
	}
	
	@RequestMapping("/editsupplier/{supId}")
	public ModelAndView editsupplier(@PathVariable("supId")String supId)
	{
		System.out.println(123);
		supplier=supplierDao.getSuplier(supId);
		List<Supplier> suppliers=supplierDao.supList();
		ModelAndView obj=new ModelAndView("supplier");
		obj.addObject("supplier",supplier);
		obj.addObject("suppliers", suppliers);
		
		return obj;
	}
	
	@RequestMapping("/deletesupplier/{supId}")
	public ModelAndView deletesupplier(@PathVariable("supId")String supId)
	{
		ModelAndView obj=new ModelAndView("redirect:/Supplier");
		supplier=supplierDao.getSuplier(supId);
//		subCategory=subCategoryDao.getSubCatId(subCatId);
//		Supplier sublist=supplierDao.getSupplier(SupId);
//		List<Product> lists= productDao.getProductBySubCategory(subCategory);
//		List<Product> lists=productDao.getProductBySupplier(SupId);
		List<Product> lists=productDao.prodList();
//		if(lists==null)
		{
//			supplierDao.deletesupplier(supplier);
			obj.addObject("msg","Supplier is deleted successfully");
		}
//		else
		{			
			
				for(Product prodlist:lists)
				{
				productDao.delete(prodlist);
				}
				categoryDao.delete(category);
			}
//			categoryDao.delete(category);
			obj.addObject("msg","Category and SubCategory is deleted successfully");
//			obj.addObject("msg", "Supplier not deleted");
//		}
		return obj;
	    }
}
