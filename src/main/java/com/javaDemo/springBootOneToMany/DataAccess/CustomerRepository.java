package com.javaDemo.springBootOneToMany.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaDemo.springBootOneToMany.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findByFirstNameContains(String firstName);
	Customer findByEmail(String email);
	
}
