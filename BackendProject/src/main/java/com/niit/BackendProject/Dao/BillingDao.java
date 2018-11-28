package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.Billing;

public interface BillingDao
{
	public boolean saveorupdate(Billing billing);
	public boolean delete(Billing billing);
	public Billing getBilling(String billId);
	public List<Billing> billList();
}
