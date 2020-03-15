package com.promineotech.mealPlanApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.mealPlanApi.entity.Dessert;
import com.promineotech.mealPlanApi.entity.Entree;
import com.promineotech.mealPlanApi.entity.Meal;
import com.promineotech.mealPlanApi.entity.SideDish;
import com.promineotech.mealPlanApi.repository.DessertRepository;
import com.promineotech.mealPlanApi.repository.EntreeRepository;
import com.promineotech.mealPlanApi.repository.MealRepository;
import com.promineotech.mealPlanApi.repository.SideDishRepository;
import com.promineotech.mealPlanApi.request.CreateMealRequest;

@Service
public class MealService {
	
	private static final Logger logger = LogManager.getLogger(MealService.class);
	
	@Autowired
	private MealRepository repo;
	
	@Autowired
	private EntreeRepository entreeRepo;
	
	@Autowired
	private SideDishRepository sideDishRepo;
	
	@Autowired
	private DessertRepository dessertRepo;
	
	public Iterable<Meal> getMeals() {
		return repo.findAll();
	}
	
	public Meal createMeal (CreateMealRequest request) {
		Entree entree = entreeRepo.findOne(request.getEntreeId());
		SideDish sideDish = sideDishRepo.findOne(request.getSideDishId());
		Dessert dessert = dessertRepo.findOne(request.getDessertId());
		
		Meal meal = new Meal();
		meal.setDessert(dessert);
		meal.setSideDish(sideDish);
		meal.setEntree(entree);
		
		return repo.save(meal);
	}
	
	public void deleteMeal(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred trying to delete meal:" + id + e);
			throw new Exception ("Unable to delete meal.");
		}
	}
	
	public List<Meal> getWeeklyMeals() {
		//Iterable of all meals
		Iterable<Meal> allMeals = repo.findAll();
		//Converting Iterable to a list
		List<Meal> allMealsList = new ArrayList<Meal>();
		for (Meal meal : allMeals) {
			allMealsList.add(meal);
		}
		Random rand = new Random();
		List<Meal> weeklyMeals = new ArrayList<Meal>();
		int totalItems = allMealsList.size();
		//randomizing indices of allMealsList, adding those to weeklyMeals, deleting from allMealsList
		for (int i = 0; i < totalItems; i++) {
			int randomIndex = rand.nextInt(allMealsList.size());
			weeklyMeals.add(allMealsList.get(randomIndex));
			allMealsList.remove(randomIndex);
		}
		//returning weeklyMeals list items 0-4
		return weeklyMeals.subList(0, 5);
	}

}
