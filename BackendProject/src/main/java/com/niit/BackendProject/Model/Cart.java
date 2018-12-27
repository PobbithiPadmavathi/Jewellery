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
@Table
@Component
public class Cart 
{
	@Id
	private String cartId;
	private Integer TotalItems=0;
	private Double GrandTotal=0.0;
	public Cart()
	{
		this.cartId="Cart"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartItems> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	@OneToMany
	private List<CartItems> cartItems;
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public Integer getTotalItems() {
		return TotalItems;
	}
	public void setTotalItems(Integer totalItems) {
		TotalItems = totalItems;
	}
	public Double getGrandTotal() {
		return GrandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		GrandTotal = grandTotal;
	}
	
}
