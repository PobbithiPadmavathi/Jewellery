package com.niit.BackendProject.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class Category 
{
	@Id
	private String catId;
	private String catName;
	
	public Category() 
	{
		this.catId="Category"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	//Relational mappings
	
	@OneToMany(mappedBy="category")
	private List<Product> product;
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
}
