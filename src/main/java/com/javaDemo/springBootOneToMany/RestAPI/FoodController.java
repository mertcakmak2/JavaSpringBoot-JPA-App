package com.javaDemo.springBootOneToMany.RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.springBootOneToMany.Business.Food.FoodManager;
import com.javaDemo.springBootOneToMany.Entities.Food;

@RestController
@RequestMapping("/api/food")
public class FoodController {
	
	@Autowired
	private FoodManager foodManager;
	
	@GetMapping("/getAll")
	public List<Food> getAll(){
		return foodManager.getAll();
	}
	
	@PostMapping("/save")
	public Food save(@RequestBody Food food) {
		return foodManager.save(food);
	}
	
	@PostMapping("/update")
	public Food update(@RequestBody Food food) {
		return foodManager.update(food);
	}

}
