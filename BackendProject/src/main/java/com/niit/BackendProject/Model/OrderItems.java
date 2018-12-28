package com.niit.BackendProject.Model;



import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems 
{
	@Id
	private String orderItemId;
	private Double price;
	private String prodId;
	public OrderItems() 
	{
		this.orderItemId="OrderItems"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
}
