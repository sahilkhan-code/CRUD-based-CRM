package com.project.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.springdemo.entity.Customer;
import com.project.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
  //inject customer service
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/list")
	public String listCutomers(Model theModel) {
		
		//get the customer service
		
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customer to the model
		theModel.addAttribute("customers",theCustomers);
			
		return "list-customers";
	}
	 @GetMapping("/showFormForAdd")
	 public String showFormForAdd(Model theModel) {
		 
		 Customer theCustomer  = new Customer();
		 
		 theModel.addAttribute("customer",theCustomer);
		 return "customer-form";
	 }
	 
	 @PostMapping("/saveCustomer")
	 public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		 customerService.saveCustomer(theCustomer);
		 
		 
		 return "redirect:/customer/list";
	 
	 }
	   
	 @GetMapping("/showFormForUpdate")
	 public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		 
		 //get the customer from service
		 Customer theCustomer = customerService.getCustomer(theId);
		 		 
		 //set customer as a model attribute for pre-populating
		 theModel.addAttribute("customer",theCustomer);
		 
		 //send over to form
		 return "customer-form";
		 
	 }
	 @GetMapping("/delete")
	 public String deleteCustomer(@RequestParam("customerId") int theId) {
		 //delete the cutomer
		 customerService.deleteCustomer(theId);
		 
		 return "redirect:/customer/list";
	 }
	 
	 
}
