package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.AuthenticationDao;
import com.niit.BackendProject.Model.Authentication;

@Transactional 
@Repository("authenticationDao")
public class AuthenticationDaoImpl implements AuthenticationDao 
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public AuthenticationDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Authentication authentication)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}


	public boolean delete(Authentication authentication) 
	{
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}


	public Authentication getAuthentication(String auth_Id) 
	{
		String qry="from Authentication where auth_Id='"+ auth_Id +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Authentication> list=(List<Authentication>)w.list();
		if(list==null)
		{
			return null;
		}
		return list.get(0);
	}

	
	public List<Authentication> authList() 
	{
		List<Authentication> authLists=(List<Authentication>)sessionFactory.getCurrentSession().createCriteria(Authentication.class)
										.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authLists;
	}

}
