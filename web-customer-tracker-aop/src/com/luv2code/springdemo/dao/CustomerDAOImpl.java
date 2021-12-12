package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// injecting the session factory (from spring-mvc-demo-servlet.xml)
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get current Hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create query
		// TODO think why MUST be Customer instead of customer
		Query<Customer> query = session.createQuery("from Customer order by lastName");

		// execute the query
		List<Customer> customers = query.getResultList(); // or first executeUpdate() ??
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", customerId);
		theQuery.executeUpdate();
	}

}
