package com.project.springdemo.dao;
import java.util.List;

import com.project.springdemo.entity.Customer;



public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

}
