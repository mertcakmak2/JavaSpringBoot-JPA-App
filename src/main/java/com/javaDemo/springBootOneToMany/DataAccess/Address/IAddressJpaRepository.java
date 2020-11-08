package com.javaDemo.springBootOneToMany.DataAccess.Address;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaDemo.springBootOneToMany.Entities.Address;

public interface IAddressJpaRepository extends JpaRepository<Address, Integer>{

}
