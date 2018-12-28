package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.SupplierDao;
import com.niit.BackendProject.Model.Supplier;

@Transactional
@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao
{

	@Autowired
	
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Supplier supplier) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}


	public boolean delete(Supplier supplier) 
	{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}


	public Supplier getSuplier(String supId) 
	{
		String qry="from Supplier where supId='"+ supId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Supplier> list=(List<Supplier>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}


	public List<Supplier> supList() 
	{
		List<Supplier> suppliers=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class)
									.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return suppliers;
	}

}
