package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.Shipping;

public interface ShippingDao 
{
	public boolean saveorupdate(Shipping shipping);
	public boolean delete(Shipping shipping);
	public Shipping getShipping(String shipId);
	public List<Shipping> shipList();
	public List<Shipping> getaddbyuser(String userId);
}
