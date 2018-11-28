package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.UserDao;
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

}
