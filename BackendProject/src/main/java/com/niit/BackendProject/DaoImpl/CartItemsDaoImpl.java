package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.CartItemsDao;
import com.niit.BackendProject.Model.CartItems;

@Transactional
@Repository("cartItemsDao")
public class CartItemsDaoImpl implements  CartItemsDao
{

	@Autowired
	
	SessionFactory sessionFactory;
	
	
	public CartItemsDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(CartItems cartItems) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		return true;
	}

	@Override
	public boolean delete(String cartItemId) {
		CartItems c =new CartItems();
		c.setCartItemId(cartItemId);
		sessionFactory.getCurrentSession().delete(c);
		return true;
	}

	
	public CartItems getCartItems(String cartItemId) 
	{
		String qry="from CartItems where cartItemId='"+ cartItemId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<CartItems> list=(List<CartItems>)w.list();
		if(list==null)
		{
			return null;
		}
		return list.get(0);
	}

	
	public List<CartItems> cartItemsList()
	{
		List<CartItems> cartItemsLists=(List<CartItems>)sessionFactory.getCurrentSession().createCriteria(CartItems.class)
								.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cartItemsLists;
	}

	@Override
	public List<CartItems> getCartItemsList(String CartId) 
	{
		String sql="from CartItems where CartId='"+CartId+"'"; 
		Query q1=sessionFactory.getCurrentSession().createQuery(sql);
		List<CartItems> list=(List<CartItems>)q1.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list;
		}
		
	}

	@Override
	public CartItems get(String id) 
	{
		String sql="from CartItems where id='"+id+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(sql);
		List<CartItems> list=(List<CartItems>)q.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public CartItems getlistall(String cartId, String prodId) {
		String sql="from CartItems where cartId='"+cartId+"' and prodId='"+prodId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(sql);
		List<CartItems> list=(List<CartItems>)q.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	
}
