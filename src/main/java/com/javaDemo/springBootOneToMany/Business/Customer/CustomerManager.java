package com.javaDemo.springBootOneToMany.Business.Customer;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaDemo.springBootOneToMany.DataAccess.Customer.ICustomerDal;
import com.javaDemo.springBootOneToMany.Entities.Customer;

@Service
public class CustomerManager implements ICustomerService {
	
	private ICustomerDal customerDal;

	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	@Override
	public List<Customer> getAll() {
		return customerDal.getAll();
	}

	@Override
	public Customer save(Customer customer) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Date date= new Date();
		String password = customer.getPassword();
		String hashPassword = passwordEncoder.encode(password);
		customer.setPassword(hashPassword);
		customer.setCreatedAt(new Timestamp(date.getTime()));
		return customerDal.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return customerDal.update(customer);
	}

	@Override
	public int delete(int id) {
		return customerDal.delete(id);
	}

	@Override
	public List<Customer> criteriaSearch(Customer customer) {
		return customerDal.criteriaSearch(customer);
	}

	@Override
	public List<Customer> saveAll(List<Customer> customers) {
		return customerDal.saveAll(customers);
	}	
}

