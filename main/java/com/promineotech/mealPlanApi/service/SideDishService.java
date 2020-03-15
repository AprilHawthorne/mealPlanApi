package com.promineotech.mealPlanApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.mealPlanApi.entity.SideDish;
import com.promineotech.mealPlanApi.repository.SideDishRepository;

@Service
public class SideDishService {
	
	private static final Logger logger = LogManager.getLogger(SideDishService.class);
	
	@Autowired
	private SideDishRepository repo;
	
	public Iterable<SideDish> getSideDishes() {
		return repo.findAll();
	}
	
	public SideDish createSideDish(SideDish sideDish) {
		return repo.save(sideDish);
	}
	
	public SideDish updateSideDish(SideDish sideDish, Long id) throws Exception {
		try {
			SideDish oldSideDish = repo.findOne(id);
			oldSideDish.setName(sideDish.getName());
			oldSideDish.setIngredients(sideDish.getIngredients());
			return repo.save(oldSideDish);
		} catch (Exception e) {
			logger.error("Exception occurred trying to update side dish:" + id + e);
			throw new Exception ("Unable to update side dish.");
		}
	}
	
	public void deleteSideDish(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred trying to delete side dish:" + id + e);
			throw new Exception ("Unable to delete side dish.");
		}
	}

}
