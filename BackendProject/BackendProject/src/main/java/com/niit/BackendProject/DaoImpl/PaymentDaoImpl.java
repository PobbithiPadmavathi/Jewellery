package com.niit.BackendProject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackendProject.Dao.PaymentDao;
import com.niit.BackendProject.Model.Payment;


@Transactional
@Repository("paymentDao")
public class PaymentDaoImpl implements PaymentDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	public PaymentDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Payment payment) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(payment);
		return true;
	}

	
	public boolean delete(Payment payment) 
	{
		sessionFactory.getCurrentSession().delete(payment);
		return true;
	}

	public Payment getPayment(String payId)
	{
		String qry="from Payment where payId='" + payId +"'";
		Query w=sessionFactory.getCurrentSession().createQuery(qry);
		List<Payment> list=(List<Payment>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	public List<Payment> payList() 
	{
		List<Payment> payLists=(List<Payment>)sessionFactory.getCurrentSession().createCriteria(Payment.class)
									.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return payLists;
	}

	
}
