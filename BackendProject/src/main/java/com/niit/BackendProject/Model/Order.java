package com.niit.BackendProject.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")
@Component
public class Order 
{
	@Id
	private String orderId;
	private Double Grand_Total;
	private Integer Total_Items;
	public Order() 
	{
		this.orderId="Order"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@OneToMany(mappedBy="order")
	private List<OrderItems> orderItems;
	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getGrand_Total() {
		return Grand_Total;
	}
	public void setGrand_Total(Double grand_Total) {
		Grand_Total = grand_Total;
	}
	public Integer getTotal_Items() {
		return Total_Items;
	}
	public void setTotal_Items(Integer total_Items) {
		Total_Items = total_Items;
	}
	@OneToOne
	@JoinColumn(name="billId")
	private Billing billing;
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shipId")
	private Shipping shipping;
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
