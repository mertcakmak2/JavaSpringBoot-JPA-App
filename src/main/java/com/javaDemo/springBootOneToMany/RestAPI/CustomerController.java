package com.javaDemo.springBootOneToMany.RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.springBootOneToMany.Business.Customer.ICustomerService;
import com.javaDemo.springBootOneToMany.Entities.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	private ICustomerService customerManager;
	
	@Autowired
	public CustomerController(ICustomerService customerManager) {
		this.customerManager = customerManager;
	}
	
	@GetMapping("/customers")
	public List<Customer> get() {
		System.out.println("get from db");
		return customerManager.getAll();
	}
		
	@GetMapping("/customer/delete/{id}")					
	public int deleteCustomer(@PathVariable int id) {
		return customerManager.delete(id);
	}
	
	@PostMapping("/customer/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerManager.update(customer);
	}
	
	@PostMapping("/customer/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerManager.save(customer);	
	}
	
	@PostMapping("/customer/addMultiple")					
	public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
		return customerManager.saveAll(customers);
	}
	
	@PostMapping("/customer/search")
	public List<Customer> criteriaSearch(@RequestBody Customer customer){
		return customerManager.criteriaSearch(customer);
	}
}
