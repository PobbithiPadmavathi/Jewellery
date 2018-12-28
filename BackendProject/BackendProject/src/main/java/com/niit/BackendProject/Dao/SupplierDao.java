package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.Supplier;

public interface SupplierDao 
{
	public boolean saveorupdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier getSuplier(String supId);
	public List<Supplier> supList();
}
