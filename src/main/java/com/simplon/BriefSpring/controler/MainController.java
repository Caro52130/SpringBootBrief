package com.simplon.BriefSpring.controler;

import org.springframework.stereotype.Controller;

import com.simplon.BriefSpring.form.CustomerForm;
import com.simplon.BriefSpring.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	private static List<Customer> customers = new ArrayList<Customer>();

	static {
		customers.add(new Customer("Julien", "123456","1 Rue de la Pinte", "59000", "Lille"));
		customers.add(new Customer("Caroline", "345678", "3 Avenue du Squat", "52130", "Louvemont"));
	}

	// Inject via application.properties
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("message", message);

		return "index";
	}

	@RequestMapping(value = { "/customerList" }, method = RequestMethod.GET)
	public String customerList(Model model) {

		model.addAttribute("customers", customers);

		return "customerList";
	}

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.GET)
	public String showAddCustomerPage(Model model) {

		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);

		return "addCustomer";
	}

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.POST)
	public String saveCustomer(Model model, //
			@ModelAttribute("customerForm") CustomerForm customerForm) {

		String name = customerForm.getName();
		String siret = customerForm.getSiret();
		String address = customerForm.getAddress();
		String postalcode = customerForm.getPostalCode();
		String city = customerForm.getCity();

		if (name != null && name.length() > 0 
				&& siret != null && siret.length() > 0 
				&& address != null && address.length() > 0
				&& postalcode != null && postalcode.length() > 0
				&& city != null && city.length() > 0) {
			Customer newCustomer = new Customer(name, siret, address, postalcode, city);
			customers.add(newCustomer);

			return "redirect:/customerList";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addPerson";
	}

}