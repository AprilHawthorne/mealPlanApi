package com.promineotech.mealPlanApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.mealPlanApi.entity.Entree;
import com.promineotech.mealPlanApi.service.EntreeService;

@RestController
@RequestMapping("/entrees")
public class EntreeController {
	
	@Autowired
	private EntreeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getEntrees() {
		return new ResponseEntity<Object>(service.getEntrees(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createEntree(@RequestBody Entree entree) {
		return new ResponseEntity<Object>(service.createEntree(entree), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateEntree(@RequestBody Entree entree, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateEntree(entree, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEntree(@PathVariable Long id) {
		try {
			service.deleteEntree(id);
			return new ResponseEntity<Object>("Successfully deleted entree with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
