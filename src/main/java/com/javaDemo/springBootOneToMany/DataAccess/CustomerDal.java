package com.javaDemo.springBootOneToMany.DataAccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaDemo.springBootOneToMany.Entities.Customer;

@Repository
public class CustomerDal implements ICustomerDal {
	
	private CustomerRepository repository;		//JPA veri tabanı işlemleri interface'si

	@Autowired
	public CustomerDal(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Customer> getCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Customer> containsCustomers(String word) {
		return repository.findByFirstNameContains(word);
	}

	@Override
	public int deleteCustomer(int id) {
		repository.deleteById(id);
		return id;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer existCustomer = repository.findById(customer.getId()).orElse(null);
		existCustomer.setEmail(customer.getEmail());
		existCustomer.setBirthDate(customer.getBirthDate());
		existCustomer.setFirstName(customer.getFirstName());
		existCustomer.setGender(customer.getGender());
		existCustomer.setLastName(customer.getLastName());
		existCustomer.setPhoneNumber(customer.getPhoneNumber());
		existCustomer.setPassword(customer.getPassword());
		return repository.save(existCustomer);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public List<Customer> saveCustomers(List<Customer> customers) {
		return repository.saveAll(customers);
	}

	

}
