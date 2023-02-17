package com.simplon.BriefSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.BriefSpring.model.Customer;
import com.simplon.BriefSpring.repository.DataRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private DataRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		this.customerRepository.save(customer);
	}
	
	@Override
	public Customer getCustomerById(long id) {
		Optional <Customer> optional = customerRepository.findById((int) id);
		Customer customer = null;
		if (optional.isPresent()) {
			customer = optional.get();
		} else {
			throw new RuntimeException("Customer not found for id :: " + id);
		}
		return customer;
	}
	
	@Override
	public void deleteCustomerById(long id) {
		this.customerRepository.deleteById((int) id);
	}
	
}
