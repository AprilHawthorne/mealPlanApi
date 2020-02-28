package com.promineotech.mealPlanApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Meal {
	
	private long id;
	private Entree entree;
	private SideDish sideDish;
	private Dessert dessert;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "entreeId")
	public Entree getEntree() {
		return entree;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	@ManyToOne
	@JoinColumn(name = "sideDishId")
	public SideDish getSideDish() {
		return sideDish;
	}

	public void setSideDish(SideDish sideDish) {
		this.sideDish = sideDish;
	}

	@ManyToOne
	@JoinColumn(name = "dessertId")
	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}

}
