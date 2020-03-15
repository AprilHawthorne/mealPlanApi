package com.promineotech.mealPlanApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.mealPlanApi.entity.SideDish;
import com.promineotech.mealPlanApi.service.SideDishService;

@RestController
@RequestMapping("/sideDishes")
public class SideDishController {
	
	@Autowired
	private SideDishService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getSideDishes() {
		return new ResponseEntity<Object>(service.getSideDishes(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createSideDish(@RequestBody SideDish sideDish) {
		return new ResponseEntity<Object>(service.createSideDish(sideDish), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateSideDish(@RequestBody SideDish sideDish, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateSideDish(sideDish, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSideDish(@PathVariable Long id) {
		try {
			service.deleteSideDish(id);
			return new ResponseEntity<Object>("Successfully deleted side dish with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


}
