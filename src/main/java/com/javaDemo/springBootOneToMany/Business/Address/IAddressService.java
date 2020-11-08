package com.javaDemo.springBootOneToMany.Business.Address;

import java.util.List;

import com.javaDemo.springBootOneToMany.Entities.Address;

public interface IAddressService {
	List<Address> getAddresses();
	Address addAddress(Address address);
	int deleteAddress(int id);
	Address updateAddress(Address address);
	Address findById(int id);
	List<Address> searchAddress(Address address);
}
