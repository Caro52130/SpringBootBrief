package com.simplon.BriefSpring.service;

import java.util.List;

import com.simplon.BriefSpring.model.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomerById(long id);
	void deleteCustomerById(long id);
}
