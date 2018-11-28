package com.niit.BackendProject.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Authentication
{
	@Id
	private String auth_Id;
	private String roleName="ROLE_USER";
	private String userName;
	public String getAuth_Id() {
		return auth_Id;
	}
	public void setAuth_Id(String auth_Id) {
		this.auth_Id = auth_Id;
	}
	public String getRoleName() {
		return roleName;
	}
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
