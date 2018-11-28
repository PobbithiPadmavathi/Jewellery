package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.CartDao;
import com.niit.BackendProject.Model.Cart;


@Transactional
@Repository("cartDao")
public class CartDaoImpl implements CartDao 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Cart cart) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	
	public boolean delete(Cart cart)
	{
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	
	public Cart getCart(String cartId) 
	{
		String qry="from Cart where cartId='"+ cartId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Cart> list=(List<Cart>)w.list();
		if(list==null)
		{
			return null;
		}
		return list.get(0);
	}

	
	public List<Cart> cartList()
	{
		List<Cart> cartLists=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class)
								.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cartLists;
	}

}
