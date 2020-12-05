package com.javaDemo.springBootOneToMany.DataAccess.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaDemo.springBootOneToMany.Entities.Ingredient;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {

}
