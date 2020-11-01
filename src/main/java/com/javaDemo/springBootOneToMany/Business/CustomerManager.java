package com.javaDemo.springBootOneToMany.Business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaDemo.springBootOneToMany.DataAccess.ICustomerDal;
import com.javaDemo.springBootOneToMany.Entities.Customer;

@Service
public class CustomerManager implements ICustomerService {
	
	private ICustomerDal customerDal;

	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	@Override
	public List<Customer> getCustomers() {
		return customerDal.getCustomers();
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDal.getCustomerById(id);
	}

	@Override
	public List<Customer> containsCustomers(String word) {
		return customerDal.containsCustomers(word);
	}

	@Override
	public int deleteCustomer(int id) {
		return customerDal.deleteCustomer(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDal.updateCustomer(customer);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDal.saveCustomer(customer);
	}

	@Override
	public List<Customer> saveCustomers(List<Customer> customers) {
		return customerDal.saveCustomers(customers);
	}

	
}
