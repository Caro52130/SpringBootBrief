package com.simplon.BriefSpring.View;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simplon.BriefSpring.controler.DataController;
import com.simplon.BriefSpring.model.Customer;

@Component
public class ViewCustomers {
	private ArrayList <Customer> CustomerList= new ArrayList<Customer>();
	private Customer customer = new Customer();
	
	@Autowired
	private DataController dc;
	
	public void displayClients() {
		 CustomerList= (ArrayList<Customer>) dc.index();
		for (int i=0; i<CustomerList.size(); i++) {
			System.out.println(CustomerList.get(i));
		}
		customer = dc.create();
			System.out.println(customer);
		
		boolean isDeleted = dc.delete();
		if (isDeleted) {
			CustomerList= (ArrayList<Customer>) dc.index();
			for (int i=0; i<CustomerList.size(); i++) {
				System.out.println(CustomerList.get(i));
			}
		}
	}
}
