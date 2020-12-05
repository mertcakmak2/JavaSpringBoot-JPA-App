package com.javaDemo.springBootOneToMany.DataAccess.Ingredient;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaDemo.springBootOneToMany.Entities.Ingredient;

public class IngredientDal implements IIngredientDal{
	
	@Autowired
	private IIngredientRepository repository;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Ingredient> getAll() {
		return repository.findAll();
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		return repository.save(ingredient);
	}

	@Override
	public Ingredient update(Ingredient ingredient) {
		return null;
	}

	@Override
	public int delete(int id) {
		repository.deleteById(id);
		return id;
	}

	@Override
	public List<Ingredient> criteriaSearch(Ingredient ingredient) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ingredient> criteriaQuery =  criteriaBuilder.createQuery(Ingredient.class);
		Root<Ingredient> root = criteriaQuery.from(Ingredient.class);
		
		List<Predicate> searchCriterias = new ArrayList<>();
		
		if(ingredient.getId() != 0 ) {
			searchCriterias.add( criteriaBuilder.equal(root.get("id"), ingredient.getId()) );
		}
		if( (ingredient.getCompulsory() != null) && (ingredient.getCompulsory() != "") ) {
			searchCriterias.add( criteriaBuilder.like(root.get("compulsory"), "%"+ingredient.getCompulsory()+"%") );
		}
		if(ingredient.getFoodId() != 0) {
			searchCriterias.add(criteriaBuilder.equal(root.get("foodId"), ingredient.getFoodId()) );		
		}
		if((ingredient.getIngredientName() != null) && (ingredient.getIngredientName() != "")) {
			searchCriterias.add(criteriaBuilder.like(root.get("ingredientName"), "%"+ingredient.getIngredientName()+"%") );
		}
		
		criteriaQuery.select( root ).where( 
				criteriaBuilder.and( searchCriterias.toArray(new Predicate[searchCriterias.size()]) ));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Ingredient> saveAll(List<Ingredient> ingredients) {
		return repository.saveAll(ingredients);
	}

}
