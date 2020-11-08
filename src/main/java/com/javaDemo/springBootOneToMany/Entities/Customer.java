package com.javaDemo.springBootOneToMany.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Customer")
public class Customer implements IEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="birthDate")
	private String birthDate;
	
	@Column(name="gender")
	private char gender;	
	
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "id")
	private List<Address> addresses;

	public Customer(String firstName, String lastName, String email, String password, String phoneNumber,
			String birthDate, char gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.gender = gender;
	}
	
	public Customer() {	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
