package com.javaDemo.springBootOneToMany.Business.Food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaDemo.springBootOneToMany.DataAccess.Food.IFoodDal;
import com.javaDemo.springBootOneToMany.Entities.Food;

@Service
public class FoodManager implements IFoodService {
	
	@Autowired
	private IFoodDal foodDal;

	@Override
	public List<Food> getAll() {
		return foodDal.getAll();
	}

	@Override
	public Food save(Food food) {
		return foodDal.save(food);
	}

	@Override
	public Food update(Food food) {
		return foodDal.update(food);
	}
	
	@Override
	public int delete(int id) {
		return foodDal.delete(id);
	}

	@Override
	public List<Food> criteriaSearch(Food food) {
		return foodDal.criteriaSearch(food);
	}

	@Override
	public List<Food> saveAll(List<Food> foods) {
		return foodDal.saveAll(foods);
	}

}
