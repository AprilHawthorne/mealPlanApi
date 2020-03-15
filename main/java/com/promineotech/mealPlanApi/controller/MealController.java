package com.promineotech.mealPlanApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.mealPlanApi.request.CreateMealRequest;
import com.promineotech.mealPlanApi.service.MealService;

@RestController
@RequestMapping("/meals")
public class MealController {
	
	@Autowired
	private MealService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getMeals() {
		return new ResponseEntity<Object>(service.getMeals(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createMeal(@RequestBody CreateMealRequest request) {
		return new ResponseEntity<Object>(service.createMeal(request), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteMeal(@PathVariable Long id) {
		try {
			service.deleteMeal(id);
			return new ResponseEntity<Object>("Successfully deleted meal with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{week}", method=RequestMethod.GET)
	public ResponseEntity<Object> getWeeklyMeals() {
		return new ResponseEntity<Object>(service.getWeeklyMeals(), HttpStatus.OK);
	}
	
	
	/*
	 * create an endpoint to get random meal - method should return Iterable<Meal>
	 * call the service
	 * get all meals from db at repo level
	 * in the service, once meals are pulled from db, select random meals
	 */

}
