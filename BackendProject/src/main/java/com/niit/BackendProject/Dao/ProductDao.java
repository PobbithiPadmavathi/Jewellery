package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.Product;

public interface ProductDao 
{
	public boolean saveorupdate(Product product);
	public boolean delete(Product product);
	public Product getProd(String prodId);
	public List<Product> prodList();
	
}
