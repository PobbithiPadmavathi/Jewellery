package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.CategoryDao;
import com.niit.BackendProject.Model.Category;

@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	SessionFactory sessionFactory;
	public CategoryDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorupdate(Category category)
	{	
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	public boolean delete(Category category) 
	{
		sessionFactory.getCurrentSession().delete(category);
		return true;	}

	public Category getCategory(String catId) 
	{
		String qry="from Category where catId='"+ catId + "'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Category> list=(List<Category>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public List<Category> catList()
	{
		List<Category> categories=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return categories;
	}

}
