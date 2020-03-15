package com.promineotech.mealPlanApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.mealPlanApi.entity.Dessert;
import com.promineotech.mealPlanApi.service.DessertService;

@RestController
@RequestMapping("/desserts")
public class DessertController {
	
	@Autowired
	private DessertService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getDesserts() {
		return new ResponseEntity<Object>(service.getDesserts(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createDessert(@RequestBody Dessert dessert) {
		return new ResponseEntity<Object>(service.createDessert(dessert), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateDessert(@RequestBody Dessert dessert, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateDessert(dessert, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDessert(@PathVariable Long id) {
		try {
			service.deleteDessert(id);
			return new ResponseEntity<Object>("Successfully deleted dessert with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


}
