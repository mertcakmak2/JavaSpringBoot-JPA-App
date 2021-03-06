package com.javaDemo.springBootOneToMany.Business.Customer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaDemo.springBootOneToMany.DataAccess.Customer.CustomerRepository;
import com.javaDemo.springBootOneToMany.Dto.AuthRequest;
import com.javaDemo.springBootOneToMany.Entities.Customer;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = repository.findByEmail(email);
		return new org.springframework.security.core.userdetails.User(
				customer.getEmail(), customer.getPassword(), new ArrayList<>());
	}
	
	public boolean checkPassword(AuthRequest authRequest) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashPassword = getCustomerPassword(authRequest.getEmail());
		String requestPassword = authRequest.getPassword();
		boolean isPasswordMatch = passwordEncoder.matches(requestPassword, hashPassword);
		return isPasswordMatch;
	}
	
	public String getCustomerPassword(String email) {
		Customer customer = repository.findByEmail(email);
		return customer.getPassword();
	}
}
