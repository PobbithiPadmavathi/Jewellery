package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.Authentication;

public interface AuthenticationDao 
{
	public boolean saveorupdate(Authentication authentication);
	public boolean delete(Authentication authentication);
	public Authentication getAuthentication(String auth_Id);
	public List<Authentication> authList();
}
