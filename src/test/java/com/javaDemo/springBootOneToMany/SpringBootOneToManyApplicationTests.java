package com.javaDemo.springBootOneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javaDemo.springBootOneToMany.DataAccess.Customer.CustomerRepository;
import com.javaDemo.springBootOneToMany.Entities.Customer;
import com.javaDemo.springBootOneToMany.Request.GetRequestObject;

@SpringBootTest
class SpringBootOneToManyApplicationTests {
	
	@Autowired
	private EntityManager entityManager;
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void getCustomers() {
		List<GetRequestObject> queries = new ArrayList<>();
		queries.add(new GetRequestObject("firstName", "Mert,Ahmet,Admin,Ayse,User" ,"like"));
		queries.add(new GetRequestObject("phoneNumber", "05352740362" ,"like"));

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = criteriaQuery.from(Customer.class);
		List<Predicate> searchCriterias = new ArrayList<>();
		
		//fieldValueleri split et
		//field valueler integer ise split ettikten sonra int e cast et
		
		
		criteriaQuery.select( root ).where( 
				criteriaBuilder.and( searchCriterias.toArray(new Predicate[searchCriterias.size()]) ));
		List<Customer> customers = entityManager.createQuery(criteriaQuery).getResultList();
	}
}
