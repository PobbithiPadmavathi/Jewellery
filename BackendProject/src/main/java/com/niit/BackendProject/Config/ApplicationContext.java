package com.niit.BackendProject.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.BackendProject.Dao.AuthenticationDao;
import com.niit.BackendProject.Dao.BillingDao;
import com.niit.BackendProject.Dao.CartDao;
import com.niit.BackendProject.Dao.CartItemsDao;
import com.niit.BackendProject.Dao.CategoryDao;
import com.niit.BackendProject.Dao.OrderDao;
import com.niit.BackendProject.Dao.OrderItemsDao;
import com.niit.BackendProject.Dao.PaymentDao;
import com.niit.BackendProject.Dao.ProductDao;
import com.niit.BackendProject.Dao.ShippingDao;
import com.niit.BackendProject.Dao.SupplierDao;
import com.niit.BackendProject.Dao.UserDao;
import com.niit.BackendProject.DaoImpl.AuthenticationDaoImpl;
import com.niit.BackendProject.DaoImpl.BillingDaoImpl;
import com.niit.BackendProject.DaoImpl.CartDaoImpl;
import com.niit.BackendProject.DaoImpl.CartItemsDaoImpl;
import com.niit.BackendProject.DaoImpl.CategoryDaoImpl;
import com.niit.BackendProject.DaoImpl.OrderDaoImpl;
import com.niit.BackendProject.DaoImpl.OrderItemsDaoImpl;
import com.niit.BackendProject.DaoImpl.PaymentDaoImpl;
import com.niit.BackendProject.DaoImpl.ProductDaoImpl;
import com.niit.BackendProject.DaoImpl.ShippingDaoImpl;
import com.niit.BackendProject.DaoImpl.SupplierDaoImpl;
import com.niit.BackendProject.DaoImpl.UserDaoImpl;
import com.niit.BackendProject.Model.Authentication;
import com.niit.BackendProject.Model.Billing;
import com.niit.BackendProject.Model.Cart;
import com.niit.BackendProject.Model.CartItems;
import com.niit.BackendProject.Model.Category;
import com.niit.BackendProject.Model.Order;
import com.niit.BackendProject.Model.OrderItems;
import com.niit.BackendProject.Model.Payment;
import com.niit.BackendProject.Model.Product;
import com.niit.BackendProject.Model.Shipping;
import com.niit.BackendProject.Model.Supplier;
import com.niit.BackendProject.Model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit.*")
public class ApplicationContext 
{
	@Bean("dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/BackendProject");
		dataSource.setUsername("padma");
		dataSource.setPassword("padhu");
		return dataSource;
				
	}
	
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.connection.pool_size","10");
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		return properties;
		
	}
	
	@Autowired
	@Bean("SessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Payment.class);
		
		return sessionBuilder.buildSessionFactory();
		
	}
	
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	
		return transactionManager;
		
	}
	
	@Autowired
	@Bean("CategoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory)
	{
		return new CategoryDaoImpl(sessionFactory);
				
	}
	@Bean("ProductDao")
	public ProductDao getProductDao(SessionFactory sessionFactory)
	{
		return new ProductDaoImpl(sessionFactory);
		
	}
	@Bean("SupplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory)
	{
		return new SupplierDaoImpl(sessionFactory);
		
	}
	
	@Bean("UserDao")
	public UserDao getUserDao(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
		
	}
	
	@Bean("BillingDao")
	public BillingDao getBilling(SessionFactory sessionFactory)
	{
		return new BillingDaoImpl(sessionFactory);
	}
	
	@Bean("AuthenticationDao")
	public AuthenticationDao getAuthentication(SessionFactory sessionFactory)
	{
		return new AuthenticationDaoImpl(sessionFactory);
	}
	
	@Bean("ShippingDao")
	public ShippingDao  getShipping(SessionFactory sessionFactory)
	{
		return new ShippingDaoImpl(sessionFactory);
	}
	
	@Bean("CartDao")
	public CartDao getCart(SessionFactory sessionFactory)
	{
		return new CartDaoImpl(sessionFactory);
	}
	
	@Bean("CartItemsDao")
	public CartItemsDao getCartItems(SessionFactory sessionFactory)
	{
		return new CartItemsDaoImpl(sessionFactory);
	}
	
	@Bean("OrderDao")
	public OrderDao getOrder(SessionFactory sessionFactory)
	{
		return new OrderDaoImpl(sessionFactory);
	}
	
	@Bean("OrderItemsDao")
	public OrderItemsDao getOrderItems(SessionFactory sessionFactory)
	{
		return new OrderItemsDaoImpl(sessionFactory);
	}
	
	@Bean("PaymentDao")
	public PaymentDao getPayment(SessionFactory sessionFactory)
	{
		return new PaymentDaoImpl(sessionFactory);
	}
}
