package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.OrderItemsDao;
import com.niit.BackendProject.Model.OrderItems;

@Transactional
@Repository("orderItemsDao")
public class OrderItemsDaoImpl implements OrderItemsDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	public OrderItemsDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(OrderItems orderItems) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
		return true;
	}

	
	public boolean delete(OrderItems orderItems) 
	{
		sessionFactory.getCurrentSession().delete(orderItems);
		return true;
	}


	public OrderItems getOrderItems(String orderItemId) 
	{
		
		String qry="from OrderItems where orderItemId='" + orderItemId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<OrderItems> list=(List<OrderItems>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	
	public List<OrderItems> orderItemsList()
	{
		List<OrderItems> orderItemslists=(List<OrderItems>)sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orderItemslists;
	}
	
}
