package com.javaDemo.springBootOneToMany.Entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="Food")
public class Food implements IEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="photo")
	private String photo;
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn( name = "foodId", referencedColumnName="id" )
	List<Ingredient> ingredients = new ArrayList<>();

	public Food(String name, double price, String description, String photo) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.photo = photo;
	}

	public Food() {
		
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	

}
