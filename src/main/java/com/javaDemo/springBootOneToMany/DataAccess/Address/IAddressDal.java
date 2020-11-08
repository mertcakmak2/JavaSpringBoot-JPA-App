package com.javaDemo.springBootOneToMany.DataAccess.Address;

import java.util.List;

import com.javaDemo.springBootOneToMany.Entities.Address;

public interface IAddressDal {
	List<Address> getAddresses();
	Address addAddress(Address address);
	int deleteAddress(int id);
	Address updateAddress(Address address);
	Address findById(int id);
	List<Address> searchAddress(Address address);
}
