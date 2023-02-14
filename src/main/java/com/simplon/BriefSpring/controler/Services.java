package com.simplon.BriefSpring.controler;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.simplon.BriefSpring.model.Customer;
import com.simplon.BriefSpring.repository.Data;

@Component 
public class Services {

	public ArrayList<Customer> getCustomerList(){
		ArrayList<Customer> customerList = Data.getData();
		return customerList;
		}
	
	public ArrayList<Customer> addCustomerList(){
		ArrayList<Customer> customerList = Data.addData();
		return customerList;
		}
	
	public ArrayList<Customer> removeCustomerList(){
		ArrayList<Customer> customerList = Data.removeData();
		return customerList;
		}
	}

