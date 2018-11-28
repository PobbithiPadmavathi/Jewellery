package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.OrderDao;
import com.niit.BackendProject.Model.Order;

@Transactional
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Order order) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}


	public boolean delete(Order order) 
	{
		sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	
	public Order getOrder(String orderId) 
	{
		
		String qry="from Order where orderId='"+ orderId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Order> list=(List<Order>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	
	public List<Order> orderList()
	{
		List<Order> orderLists=(List<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orderLists;
	}
	
}
