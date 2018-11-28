package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.BillingDao;
import com.niit.BackendProject.Model.Billing;

@Transactional
@Repository("billingDao")
public class BillingDaoImpl implements BillingDao
{

	@Autowired
	
	SessionFactory sessionFactory;
	
	public BillingDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Billing billing) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	}

	
	public boolean delete(Billing billing) 
	{
		sessionFactory.getCurrentSession().delete(billing);
		return true;
	}


	public Billing getBilling(String billId) 
	{
		String qry="from Billing where billId='" + billId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Billing> list=(List<Billing>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}


	public List<Billing> billList() 
	{
		List<Billing> lists=(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class)
									.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return lists;
	}
	
}
