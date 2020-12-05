package com.javaDemo.springBootOneToMany.DataAccess.Food;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaDemo.springBootOneToMany.Entities.Food;

public interface IFoodRepository extends JpaRepository<Food, Integer>{

}
