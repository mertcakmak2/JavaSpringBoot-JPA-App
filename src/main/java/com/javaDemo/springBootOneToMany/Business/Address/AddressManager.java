package com.javaDemo.springBootOneToMany.Business.Address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaDemo.springBootOneToMany.DataAccess.Address.IAddressDal;
import com.javaDemo.springBootOneToMany.Entities.Address;

@Service
public class AddressManager implements IAddressService {
	
	@Autowired
	private IAddressDal addressDal;

	@Override
	public List<Address> getAddresses() {
		return addressDal.getAddresses();
	}

	@Override
	public Address addAddress(Address address) {
		return addressDal.addAddress(address);
	}

	@Override
	public int deleteAddress(int id) {
		addressDal.deleteAddress(id);
		return id;
	}

	@Override
	public Address updateAddress(Address address) {
		return addressDal.updateAddress(address);
	}

	@Override
	public Address findById(int id) {
		return addressDal.findById(id);
	}

	@Override
	public List<Address> searchAddress(Address address) {
		return addressDal.searchAddress(address);
	}

}
