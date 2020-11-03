package com.javaDemo.springBootOneToMany.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaDemo.springBootOneToMany.DataAccess.CustomerRepository;
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

}
