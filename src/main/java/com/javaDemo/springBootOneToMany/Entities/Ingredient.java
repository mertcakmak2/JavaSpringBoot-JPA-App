package com.javaDemo.springBootOneToMany.Entities;

import javax.persistence.*;

@Entity
@Table(name="Ingredient")
public class Ingredient implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ingredientName")
	private String ingredientName;
	
	@Column(name="compulsory")
	private String compulsory;

	private int foodId;

	public Ingredient(String ingredientName, String compulsory, int foodId) {
		this.ingredientName = ingredientName;
		this.compulsory = compulsory;
		this.foodId = foodId;
	}

	public Ingredient() {
		
	}

	public int getId() {
		return id;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getCompulsory() {
		return compulsory;
	}

	public void setCompulsory(String compulsory) {
		this.compulsory = compulsory;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	
}
