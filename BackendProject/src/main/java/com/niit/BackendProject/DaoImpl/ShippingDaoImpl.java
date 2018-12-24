package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.ShippingDao;
import com.niit.BackendProject.Model.Shipping;

@Transactional
@Repository("shippingDao")
public class ShippingDaoImpl implements ShippingDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Shipping shipping)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	
	public boolean delete(Shipping shipping)
	{
		sessionFactory.getCurrentSession().delete(shipping);
		return true;
	}

	
	public Shipping getShipping(String shipId) 
	{
		String qry="from Shipping where shipId='"+ shipId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Shipping> list=(List<Shipping>)w.list();
		if(list==null)
		{
			return null;
		}
		return list.get(0);
	}

	
	public List<Shipping> shipList() 
	{
		List<Shipping> shipLists=(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class)
									.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return shipLists;
	}

	@Override
	public List<Shipping> getaddbyuser(String userId)
	{
		String q1="from Shipping where userId='"+userId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Shipping> list=(List<Shipping>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list;
	}

}
