package com.niit.BackendProject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackendProject.Dao.CategoryDao;
import com.niit.BackendProject.Model.Category;

public class CategoryTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Category cat= (Category)ctx.getBean("category");//This object created by @Component in Category class 
		CategoryDao catDao= (CategoryDao)ctx.getBean("categoryDao");
		
		cat.setCatId("c101");
		cat.setCatName("category1");
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("Category is Saved");
		} else {
			System.out.println("Category not Saved");
		}
		
		cat.setCatId("c102");
		cat.setCatName("category2");
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("Category is Saved");
		} else {
			System.out.println("Category not Saved");
		}
		
		cat.setCatId("c103");
		cat.setCatName("category3");
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("Category is Saved");
		} else {
			System.out.println("Category not Saved");
		}
		
		
		cat=catDao.getCategory("c101");
		if(cat==null)
		{
			System.out.println("Category not exists");
		}
		else
		{
			System.out.println("Category exists");
			System.out.println(cat.getCatId());
			System.out.println(cat.getCatName());
		}
		
		cat=catDao.getCategory("c103");
		if(cat==null)
		{
			System.out.println("Category not exists");
		}
		else
		{
			System.out.println("Category deleting..");
			if(catDao.delete(cat)==true)
			{
				System.out.println("Category deleted");
			}
			else
			{
				System.out.println("Category not deleted");
			}
		}
		
		
		List<Category> catlist=catDao.catList();
		if(catlist.isEmpty()||catlist==null)
		{
			System.out.println("Categories not existing");
		}
		else
		{
			for(Category c:catlist)
			{
				System.out.println(c.getCatId());
				System.out.println(c.getCatName());
			}
		}
		ctx.close();
	}
}
