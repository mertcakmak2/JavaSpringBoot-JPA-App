package com.javaDemo.springBootOneToMany.DataAccess.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.javaDemo.springBootOneToMany.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> , 
	PagingAndSortingRepository<Customer, Integer>{
	
	List<Customer> findByFirstNameContains(String firstName);
	Customer findByEmail(String email);
	
}
