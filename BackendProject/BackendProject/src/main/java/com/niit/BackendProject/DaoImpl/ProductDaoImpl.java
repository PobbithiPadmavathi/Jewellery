package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.ProductDao;
import com.niit.BackendProject.Model.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


	public boolean saveorupdate(Product product) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	
	public boolean delete(Product product) 
	{
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}


	public Product getProd(String prodId) 
	{
		String qry="from Product where prodId='"+ prodId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Product> list=(List<Product>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	
	public List<Product> prodList()
	{
		List<Product> products=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class)
										.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return products;
	}

}
