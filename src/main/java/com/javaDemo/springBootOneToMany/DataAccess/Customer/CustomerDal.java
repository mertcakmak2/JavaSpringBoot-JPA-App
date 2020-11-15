package com.javaDemo.springBootOneToMany.DataAccess.Customer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaDemo.springBootOneToMany.Entities.Customer;

@Repository
public class CustomerDal implements ICustomerDal {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private CustomerRepository repository;		//JPA veri tabanı işlemleri interface'si

	@Override
	public List<Customer> getAll() {
		return repository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		Customer existCustomer = repository.findById(customer.getId()).orElse(null);
		Date date= new Date();
		existCustomer.setUpdatedAt(new Timestamp(date.getTime()));
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
	public int delete(int id) {
		repository.deleteById(id);
		return id;
	}

	@Override
	public List<Customer> criteriaSearch(Customer customer) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = criteriaQuery.from(Customer.class);
		
		String email = customer.getEmail();
		String birthDate = customer.getBirthDate();
		String firstName = customer.getFirstName();
//		char gender = customer.getGender();
		int id = customer.getId();
		String lastName = customer.getLastName();
		String phoneNumber = customer.getPhoneNumber();
		
		List<Predicate> searchCriterias = new ArrayList<>();

		if( (email != "" ) && (email != null) ) { 
			searchCriterias.add( criteriaBuilder.like( root.get("email"), "%"+email+"%") );
		}
		if( (birthDate != "" ) && (birthDate != null) ) {
			searchCriterias.add( criteriaBuilder.like( root.get("birthDate"), "%"+birthDate+"%") );
		}
		if( (firstName != "" ) && (firstName != null) ) {
			searchCriterias.add( criteriaBuilder.like( root.get("firstName"), "%"+firstName+"%") );
		}
//		if( gender != ' ' ) {
//			searchCriterias.add( criteriaBuilder.like( root.get("gender"), "%"+gender+"%") );
//		}
		if(id != 0) {
			searchCriterias.add( criteriaBuilder.equal( root.get("id"), id) );
		}
		if( (lastName != "" ) && (lastName != null) ) {
			searchCriterias.add( criteriaBuilder.like( root.get("lastName"), "%"+lastName+"%") );
		}
		if( (phoneNumber != "" ) && (phoneNumber != null) ) {
			searchCriterias.add( criteriaBuilder.like( root.get("phoneNumber"), "%"+phoneNumber+"%") );
		}
		
		//between kullanımı
		//searchCriterias.add( criteriaBuilder.between( root.get("birthDate"), startRangeDateOfBirth, endRangeDateOfBirth) );
		
		//sayısal değer için kullanım
		//searchCriterias.add( criteriaBuilder.equal( root.get("mobile"), mobile) );

		criteriaQuery.select( root ).where( 
				criteriaBuilder.and( searchCriterias.toArray(new Predicate[searchCriterias.size()]) ));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Customer> saveAll(List<Customer> customers) {
		return repository.saveAll(customers);
	}

}
