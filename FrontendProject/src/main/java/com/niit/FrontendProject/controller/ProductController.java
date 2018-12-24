package com.niit.FrontendProject.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BackendProject.Dao.CategoryDao;
import com.niit.BackendProject.Dao.ProductDao;
import com.niit.BackendProject.Dao.SupplierDao;
import com.niit.BackendProject.Model.Category;
import com.niit.BackendProject.Model.Product;
import com.niit.BackendProject.Model.Supplier;
import com.niit.FrontendProject.FileInput.FileInput;


@Controller
public class ProductController 
{
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	String path="D:\\educationaltworkspace\\FrontendProject\\src\\main\\webapp\\resources\\images\\";
	
	@RequestMapping("/Product")
	public ModelAndView productForm()
	{
		List<Product> products=productDao.prodList();
		List<Category> categories=categoryDao.catList();
		List<Supplier> suppliers=supplierDao.supList();
		ModelAndView obj=new ModelAndView("product");
//		ModelAndView obj1=new ModelAndView("Product");
		obj.addObject("supplier", new Supplier());
		obj.addObject("suppliers", suppliers);
		obj.addObject("category", new Category());
		obj.addObject("categories", categories);
		obj.addObject("product", new Product());
		obj.addObject("products", products);
		return obj;		
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute("product")Product product)
	{
		ModelAndView obj= new ModelAndView("redirect:/Product");
		FileInput.upload(path,product.getPimg(),product.getProdId()+".jpg");
//		categoryDao.saveorupdate(category);
//		obj.addObject("echo", "Category is add successfully");
		if(productDao.saveorupdate(product)==true)
		{
			obj.addObject("echo", "Product is added successfully");
			
		}
		else
		{
			obj.addObject("msg","Sorry! Product is not added");
		}
		obj.setViewName("redirect:/Product");
		return obj;
	}
	
	/*@RequestMapping(value="/addprod", method=RequestMethod.POST)
	public ModelAndView addproduct(HttpServletRequest req, @ModelAttribute("product")Product product, @RequestParam("pimg") MultipartFile file, @ModelAttribute("user")User user) {
		ModelAndView obj = new ModelAndView("redirect:/Product");
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		product.setImageName(filename);
				productDao.saveorupdate(product);
		
		try
		{
			byte[] imagebyte= file.getBytes();
			BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/Resources/"+filename));
				fos.write(imagebyte);
			fos.close();
		}
		
		catch(Exception e)
		{
			
		}
		return obj;

}*/

	@RequestMapping("/editproduct/{prodId}")
	public ModelAndView editcategory(@PathVariable("prodId")String prodId)
	{
		System.out.println(123);
		List<Product> products=productDao.prodList();
		List<Category> categories=categoryDao.catList();
		List<Supplier> suppliers=supplierDao.supList();
		ModelAndView obj=new ModelAndView("product");
		product=productDao.getProd(prodId);
		obj.addObject("product",product);
		obj.addObject("products", products);
		obj.addObject("categories", categories);
		obj.addObject("suppliers", suppliers);
		return obj;
	}
	
	@RequestMapping("/deleteproduct/{prodId}")
	public ModelAndView deleteproduct(@PathVariable("prodId")String prodId)
	{
		ModelAndView obj=new ModelAndView("redirect:/Product");
		product=productDao.getProd(prodId);
//		subCategory=subCategoryDao.getSubCatId(subCatId);
		Product sublist=productDao.getProd(prodId);
//		List<Product> lists= productDao.getProductBySubCategory(subCategory);
//		List<Product> lists=productDao.getProductByCategory(category);
//		if(sublist==null)
//		{
			productDao.delete(product);
			obj.addObject("msg","Product is deleted successfully");
//		}
//		else
//		{			
//			for(SubCategory s:sublist)				//Doubt section
//			{
//				List<Product> p=productDao.getProductBySubCategory(s);
//				
//				for(Product prodlist:p)
//				{
//				productDao.delete(prodlist);
//				}
//				subCategoryDao.delete(s);
//			}
//			categoryDao.delete(category);
//			obj.addObject("msg","Category and SubCategory is deleted successfully");
			obj.addObject("msg", "Product not deleted");
//		}
		return obj;

	}
}