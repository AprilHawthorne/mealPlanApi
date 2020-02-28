package com.promineotech.mealPlanApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.mealPlanApi.entity.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {

}
