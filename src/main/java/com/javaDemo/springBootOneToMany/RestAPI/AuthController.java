package com.javaDemo.springBootOneToMany.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.springBootOneToMany.Business.ICustomerService;
import com.javaDemo.springBootOneToMany.DataAccess.CustomerRepository;
import com.javaDemo.springBootOneToMany.Entities.AuthRequest;
import com.javaDemo.springBootOneToMany.Entities.Customer;
import com.javaDemo.springBootOneToMany.Service.CustomUserDetailsService;
import com.javaDemo.springBootOneToMany.Util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	private AuthenticationManager authenticationManager;
	private ICustomerService customerManager;	//auth servisi olmalı
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	public AuthController(AuthenticationManager authenticationManager, ICustomerService customerManager) {
		this.authenticationManager = authenticationManager;
		this.customerManager = customerManager;
	}
	
	@PostMapping("/register")
	public Customer register(@RequestBody Customer customer) {
		return customerManager.saveCustomer(customer);
	}
	
	@PostMapping("/login")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Customer customer = repository.findByEmail(authRequest.getEmail());
		boolean isPasswordMatch = passwordEncoder.matches(authRequest.getPassword(), customer.getPassword());
		if(!isPasswordMatch) throw new Exception("invalid username/password");
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getEmail(), customer.getPassword()));
		} catch(Exception e) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getEmail());
	}

}
