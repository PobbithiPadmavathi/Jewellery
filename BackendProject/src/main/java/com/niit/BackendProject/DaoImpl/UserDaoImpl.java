package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.UserDao;
import com.niit.BackendProject.Model.Authentication;
import com.niit.BackendProject.Model.Billing;
import com.niit.BackendProject.Model.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao
{

	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) 
	{ 
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(User user)
	{	
		Authentication auth= new Authentication();
		auth.setUserName(user.getEmailIid());
		Billing bill = new Billing();
		bill.setBillName(user.getUserName());
		bill.setPhNo(user.getPhoneNo());
		bill.setAddress(user.getAddress());
		bill.setUser(user);
		user.setBilling(bill);
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		sessionFactory.getCurrentSession().saveOrUpdate(bill);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}


	public boolean delete(User user) 
	{
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}


	public User getUser(String userId) 
	{	
		String qry="from User where userId='"+ userId + "'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<User> list=(List<User>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
		
	}


	public List<User> userList() 
	{
		List<User> users=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class)
								.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return users;
	}


	public User isValid(String emailid, String password) 
	{
		String qry="from User where emilId='"+emailid+ "'password='"+password+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<User> list=(List<User>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	
	public User getUseremail(String currusername)
	{
		String q1="from User where emailIid='"+currusername+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<User> list=(List<User>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

}
