package com.promineotech.mealPlanApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.mealPlanApi.entity.Entree;
import com.promineotech.mealPlanApi.repository.EntreeRepository;

@Service
public class EntreeService {
	
	private static final Logger logger = LogManager.getLogger(EntreeService.class);
	
	@Autowired
	private EntreeRepository repo;
	
	public Iterable<Entree> getEntrees() {
		return repo.findAll();
	}
	
	public Entree createEntree(Entree entree) {
		return repo.save(entree);
	}
	
	public Entree updateEntree(Entree entree, Long id) throws Exception {
		try {
			Entree oldEntree = repo.findOne(id);
			oldEntree.setCategory(entree.getCategory());
			oldEntree.setName(entree.getName());
			oldEntree.setIngredients(entree.getIngredients());
			return repo.save(oldEntree);
		} catch (Exception e) {
			logger.error("Exception occurred trying to update entree:" + id + e);
			throw new Exception ("Unable to update entree.");
		}
	}
	
	public void deleteEntree(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred trying to delete entree:" + id + e);
			throw new Exception ("Unable to delete entree.");
		}
	}
	
}
