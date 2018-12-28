package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.Payment;

public interface PaymentDao 
{
	public boolean saveorupdate(Payment payment);
	public boolean delete(Payment payment);
	public Payment getPayment(String payId);
	public List<Payment> payList();
}
