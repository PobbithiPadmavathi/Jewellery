package com.niit.BackendProject.Dao;

import java.util.List;

import com.niit.BackendProject.Model.User;

public interface UserDao
{
	public boolean saveorupdate(User user);
	public boolean delete(User user);
	public User getUser(String userId);
	public List<User> userList();
}
