package com.javaDemo.springBootOneToMany.DataAccess.Food;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaDemo.springBootOneToMany.Entities.Food;

@Repository
public class FoodDal implements IFoodDal {
	
	@Autowired
	private IFoodRepository repository;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Food> getAll() {
		return repository.findAll();
	}

	@Override
	public Food save(Food food) {
		return repository.save(food);
	}

	@Override
	public Food update(Food food) {
		Food existFood = repository.getOne(food.getId());
		
		String description = food.getDescription() == null ? existFood.getDescription() : food.getDescription();
		String name = food.getName() == null ? existFood.getName() : food.getName();
		String photo = food.getPhoto() == null ? existFood.getPhoto() : food.getPhoto();
		double price = food.getPrice() == 0 ? existFood.getPrice() : food.getPrice();
		
		existFood.setDescription(description);
		existFood.setName(name);
		existFood.setPhoto(photo);
		existFood.setPrice(price);
		return repository.save(existFood);
	}

	@Override
	public int delete(int id) {
		repository.deleteById(id);
		return id;
	}

	@Override
	public List<Food> criteriaSearch(Food food) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Food> criteriaQuery = criteriaBuilder.createQuery(Food.class);
		Root<Food> root = criteriaQuery.from(Food.class);
		
		List<Predicate> searchCriterias = new ArrayList<>();
		
		if((food.getDescription() != null) && (food.getDescription() != ""))
			searchCriterias.add(criteriaBuilder.like(root.get("description"), "%"+food.getDescription()+"%"));
		if(food.getId() != 0)
			searchCriterias.add(criteriaBuilder.equal(root.get("id"), food.getId()));
		if((food.getName() != null) && (food.getName() != ""))
			searchCriterias.add(criteriaBuilder.like(root.get("name"), "%"+food.getName()+"%"));
		if((food.getPhoto() != null) && (food.getPhoto() != ""))
			searchCriterias.add(criteriaBuilder.like(root.get("photo"), "%"+food.getPhoto()+"%"));
		if(food.getPrice() != 0)
			searchCriterias.add(criteriaBuilder.equal(root.get("price"), food.getPrice()));
		
		criteriaQuery.select( root ).where( 
				criteriaBuilder.and( searchCriterias.toArray(new Predicate[searchCriterias.size()]) ));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Food> saveAll(List<Food> foods) {
		return repository.saveAll(foods);
	}

}
