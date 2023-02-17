package com.simplon.BriefSpring.controler;

import org.springframework.stereotype.Controller;

import com.simplon.BriefSpring.model.*;
import com.simplon.BriefSpring.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@Autowired
	private CustomerService customerService;	
    
//	// Inject via application.properties
//	@Value("${welcome.message}")
//	private String message;

	@Value("${error.message}")
	private String errorMessage;

//	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//	public String index(Model model) {
//
//		model.addAttribute("message", message);
//
//		return "index";
//	}

	@RequestMapping(value = { "/customerList" }, method = RequestMethod.GET)
	public String customerList(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customerList";
	}

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.GET)
	public String showAddCustomerPage(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "addCustomer";
	}

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.POST)
	public String saveCustomer(Model model, @ModelAttribute("customer") Customer customer) {

		String name = customer.getName();
		String siret = customer.getSiret();
		String address = customer.getAddress();
		String postalcode = customer.getPostalCode();
		String city = customer.getCity();

		if (name != null && name.length() > 0 
				&& siret != null && siret.length() > 0 
				&& address != null && address.length() > 0
				&& postalcode != null && postalcode.length() > 0
				&& city != null && city.length() > 0) {
			customerService.saveCustomer(customer);

			return "redirect:/customerList";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addCustomer";
	}
	
	@RequestMapping(value = { "/updateCustomer/{id}" }, method = RequestMethod.GET)
	public String showUpdateCustomerPage(@PathVariable(value = "id") long id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "updateCustomer";
	}
	
	@RequestMapping(value = {"deleteCustomer/{id}"}, method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable(value = "id") long id) {
		this.customerService.deleteCustomerById(id);
		return "redirect:/customerList";
	}
}