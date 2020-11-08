package com.javaDemo.springBootOneToMany.RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.springBootOneToMany.DataAccess.Address.IAddressDal;
import com.javaDemo.springBootOneToMany.Entities.Address;
//import com.javaDemo.springBootOneToMany.Response.EntitiesResponse;
//import com.javaDemo.springBootOneToMany.Response.EntityResponse;
//import com.javaDemo.springBootOneToMany.Response.IEntityResponse;

@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	private IAddressDal addressManager;
	
	
	@GetMapping("/addresses")
	public List<Address> getAddresses(){
		return addressManager.getAddresses();
	}
	
	@PostMapping("/address/add")
	public Address addAddress(@RequestBody Address address) {
		return addressManager.addAddress(address);
	}
	
	@GetMapping("/address/delete/{id}")
	public int deleteAddress(@PathVariable int id) {
		return addressManager.deleteAddress(id);
	}
	
	@PostMapping("/address/update")
	public Address updateAddress(@RequestBody Address address) {
		return addressManager.updateAddress(address);
	}
	
	@GetMapping("/address/{id}")
	public Address findById(@PathVariable int id) {
		return addressManager.findById(id);
	}
	
	@PostMapping("/address/search")
	public List<Address> searchCustomer(@RequestBody Address address){
		return addressManager.searchAddress(address);
	}

	
	//Custom Response Object
//	@GetMapping("/customResponse")
//	public IEntityResponse customResponse() {
//		EntitiesResponse<Address> response = new EntitiesResponse<Address>();
//		List<Address> addresses =  addressManager.getAddresses();
//		response.setData(addresses);
//		response.setStatus("Success");
//		response.setStatusCode(200);
//		return response;
//		
//		EntityResponse<Address> response = new EntityResponse<Address>();
//		List<Address> addresses =  addressManager.getAddresses();
//		response.setData(addresses.get(0));
//		response.setStatus("Success");
//		response.setStatusCode(200);
//		return response;
//	}
}
