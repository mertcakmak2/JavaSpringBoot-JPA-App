package com.javaDemo.springBootOneToMany.DataAccess.Address;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaDemo.springBootOneToMany.Entities.Address;

@Repository
public class AddressDal implements IAddressDal {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private IAddressJpaRepository repository;
	
	@Override
	public List<Address> getAddresses() {
		return repository.findAll();
	}

	@Override
	public Address addAddress(Address address) {
		return repository.save(address);
	}

	@Override
	public int deleteAddress(int id) {
		repository.deleteById(id);
		return id;
	}

	@Override
	public Address updateAddress(Address address) {
		Address existAddress = repository.findById(address.getId()).orElse(null);
		existAddress.setAddressDescription(address.getAddressDescription());
		existAddress.setAddressTitle(address.getAddressTitle());
		existAddress.setDistrict(address.getDistrict());
		existAddress.setFirstName(address.getFirstName());
		existAddress.setLastName(address.getLastName());
		existAddress.setNeighborhood(address.getNeighborhood());
		existAddress.setPhoneNumber(address.getPhoneNumber());
		existAddress.setProvince(address.getProvince());
		return repository.save(existAddress);
	}

	@Override
	public Address findById(int id) {
		return repository.findById(id).orElse(null); 
	}

	@Override
	public List<Address> searchAddress(Address address) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Address> criteriaQuery = criteriaBuilder.createQuery(Address.class);
		Root<Address> root = criteriaQuery.from(Address.class);
						
		int addressId = address.getId();
		String addressDescription = address.getAddressDescription();
		String addressTitle = address.getAddressTitle();
		String district = address.getDistrict();
		String firtName = address.getFirstName();
		String lastName = address.getLastName();
		String neighborhood = address.getNeighborhood();
		String phoneNumber = address.getPhoneNumber();
		String province = address.getProvince();
		
		List<Predicate> searchCriterias = new ArrayList<>();
		
		if(addressDescription != "" && addressDescription != null ) {
			searchCriterias.add(criteriaBuilder.like( root.get("addressDescription"), "%"+addressDescription+"%"));
		}
		if(addressId != 0) {
			searchCriterias.add( criteriaBuilder.equal( root.get("id"), addressId) );
		}
		if(addressTitle != "" && addressTitle != null ) {
			searchCriterias.add(criteriaBuilder.like( root.get("addressTitle"), "%"+addressTitle+"%"));
		}
		if(district != "" && district != null ) {
			searchCriterias.add(criteriaBuilder.like( root.get("district"), "%"+district+"%"));
		}
		if(firtName != "" && firtName != null ) {
			searchCriterias.add(criteriaBuilder.like( root.get("firtName"), "%"+firtName+"%"));
		}
		if(lastName != "" && lastName != null ) {
			searchCriterias.add(criteriaBuilder.like( root.get("lastName"), "%"+lastName+"%"));
		}
		if(neighborhood != "" && neighborhood != null ) {
			searchCriterias.add(criteriaBuilder.like( root.get("neighborhood"), "%"+neighborhood+"%"));
		}
		if(phoneNumber != "" && phoneNumber != null ) {
			searchCriterias.add(criteriaBuilder.like( root.get("phoneNumber"), "%"+phoneNumber+"%"));
		}
		if(province != "" && province != null ) {
			searchCriterias.add(criteriaBuilder.like( root.get("province"), "%"+province+"%"));
		}
		
		criteriaQuery.select( root ).where( 
				criteriaBuilder.and( searchCriterias.toArray(new Predicate[searchCriterias.size()]) ));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
