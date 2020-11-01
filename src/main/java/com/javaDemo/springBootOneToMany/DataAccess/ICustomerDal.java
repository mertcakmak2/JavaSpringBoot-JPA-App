package com.javaDemo.springBootOneToMany.DataAccess;

import java.util.List;

import com.javaDemo.springBootOneToMany.Entities.Customer;

public interface ICustomerDal {
	List<Customer> getCustomers(); 
	Customer getCustomerById(int id);
	List<Customer> containsCustomers(String word);
	int deleteCustomer(int id);
	Customer updateCustomer(Customer customer);
	Customer saveCustomer(Customer customer);
	List<Customer> saveCustomers(List<Customer> customers);
}
