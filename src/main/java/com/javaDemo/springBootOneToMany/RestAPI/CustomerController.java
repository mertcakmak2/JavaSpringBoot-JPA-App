package com.javaDemo.springBootOneToMany.RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.springBootOneToMany.Business.ICustomerService;
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
		return customerManager.getCustomers();				//Çalışıyor
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerManager.getCustomerById(id);			//Çalışıyor
	}
	
	@GetMapping("/customer/contains/{word}")
	public List<Customer> containsCustomers(@PathVariable String word) {
		return customerManager.containsCustomers(word);		//Çalışıyor
	}
	
	@GetMapping("/customer/delete/{id}")					
	public int deleteCustomer(@PathVariable int id) {
		return customerManager.deleteCustomer(id);			//Çalışıyor
	}
	
	@PostMapping("/customer/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerManager.updateCustomer(customer);	//Çalışıyor
	}
	
	@PostMapping("/customer/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerManager.saveCustomer(customer);		//Çalışıyor
	}
	
	@PostMapping("/customer/addMultiple")					
	public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
		return customerManager.saveCustomers(customers);	//Çalışıyor
	}
	
	@PostMapping("/customer/search")
	public List<Customer> searchCustomer(@RequestBody Customer customer){
		return customerManager.searchCustomer(customer);
	}
	
//	private ICustomerService customerService;
//
//	@Autowired
//	public CustomerController(ICustomerService customerService) {
//		this.customerService = customerService;
//	}
//	
//	@GetMapping("/customers")
//	@Transactional
//	public List<Customer> get() {
//		return this.customerService.getAll();
//	}
}
