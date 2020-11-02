package com.javaDemo.springBootOneToMany.Entities;

import javax.persistence.*;

@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="province")
	private String province;
	
	@Column(name="district")
	private String district;
	
	@Column(name="neighborhood")
	private String neighborhood;
	
	@Column(name="addressDescription")
	private String addressDescription;
	
	@Column(name="addressTitle")
	private String addressTitle;

	public Address(String firstName, String lastName, String phoneNumber, String province, String district,
			String neighborhood, String addressDescription, String addressTitle) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.province = province;
		this.district = district;
		this.neighborhood = neighborhood;
		this.addressDescription = addressDescription;
		this.addressTitle = addressTitle;
	}
	
	public Address() {}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getAddressDescription() {
		return addressDescription;
	}

	public void setAddressDescription(String addressDescription) {
		this.addressDescription = addressDescription;
	}

	public String getAddressTitle() {
		return addressTitle;
	}

	public void setAddressTitle(String addressTitle) {
		this.addressTitle = addressTitle;
	}
	

	}

