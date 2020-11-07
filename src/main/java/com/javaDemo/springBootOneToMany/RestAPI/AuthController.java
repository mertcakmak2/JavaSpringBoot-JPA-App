package com.javaDemo.springBootOneToMany.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.springBootOneToMany.Business.Auth.IAuthService;
import com.javaDemo.springBootOneToMany.Business.Customer.ICustomerService;
import com.javaDemo.springBootOneToMany.Entities.AuthRequest;
import com.javaDemo.springBootOneToMany.Entities.Customer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private IAuthService authManager; 
	@Autowired
	private ICustomerService customerManager;
	
		
	@PostMapping("/register")
	public Customer register(@RequestBody Customer customer) {
		return customerManager.saveCustomer(customer);
	}
	
	@PostMapping("/login")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		return authManager.login(authRequest);
	}

}
