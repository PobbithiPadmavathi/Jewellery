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
public class User
{
	@Id
	private String userId;
	private String userName;
	private String address;
	private String phoneNo;
	private String emailIid;
	private String password;
	
	@OneToOne(mappedBy="user")
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@OneToMany(mappedBy="user")
	private List<Shipping> shipping;
	
	@OneToOne(mappedBy="user")
	@JoinColumn(name="billId")
	private Billing billing;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailIid() {
		return emailIid;
	}
	public void setEmailIid(String emailIid) {
		this.emailIid = emailIid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
