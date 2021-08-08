package com.project.springdemo.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@ Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		
	Session currentSession = sessionFactory.getCurrentSession();
	
	//create query..sort by lastName
	
	Query<Customer> theQuery = 
			currentSession.createQuery("from Customer order by first_Name",Customer.class);
	
	//execute query
		List<Customer> customer = theQuery.getResultList();
		
		//return customer
		
		return customer;
	}



	@Override
	public void saveCustomer(Customer theCustomer) {
		//get hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save or update the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}



	 
	@Override
	public Customer getCustomers(int theId) {
		
		//get the current session
		Session currentSession  = sessionFactory.getCurrentSession();
		
		//retrieve data from database
		Customer theCustomer = currentSession.get(Customer.class,theId);
		
		return theCustomer;
	}



	@Override
	public void deleteCustomer(int theId) {
		
		//get the curretn session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query for deletion
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId",theId);
		theQuery.executeUpdate();
	}
}






























