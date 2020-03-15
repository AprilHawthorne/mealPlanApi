package com.promineotech.mealPlanApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.mealPlanApi.entity.Dessert;
import com.promineotech.mealPlanApi.repository.DessertRepository;

@Service
public class DessertService {
	
	private static final Logger logger = LogManager.getLogger(DessertService.class);
	
	@Autowired
	private DessertRepository repo;
	
	public Iterable<Dessert> getDesserts() {
		return repo.findAll();
	}
	
	public Dessert createDessert(Dessert dessert) {
		return repo.save(dessert);
	}
	
	public Dessert updateDessert(Dessert dessert, Long id) throws Exception {
		try {
			Dessert oldDessert = repo.findOne(id);
			oldDessert.setName(dessert.getName());
			oldDessert.setIngredients(dessert.getIngredients());
			return repo.save(oldDessert);
		} catch (Exception e) {
			logger.error("Exception occurred trying to update dessert:" + id + e);
			throw new Exception ("Unable to update dessert.");
		}
	}
	
	public void deleteDessert(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred trying to delete dessert:" + id + e);
			throw new Exception ("Unable to delete dessert.");
		}
	}

}
