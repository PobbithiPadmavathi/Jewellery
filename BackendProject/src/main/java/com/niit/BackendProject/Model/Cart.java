package com.niit.BackendProject.Model;

import java.util.List;

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
	private Integer TotalItems;
	private Double GrandTotal;
	
	@OneToOne(mappedBy="cart")
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy="Cart")
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
