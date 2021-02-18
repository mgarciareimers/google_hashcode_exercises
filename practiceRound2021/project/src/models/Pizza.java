package models;

import java.util.Collections;
import java.util.List;

import evenMorePizza.commons.Constants;

public class Pizza {
	private int id;
	private int numberIngredients;
	private List<String> ingredients;
	
	private String ingredientsString;
	
	public Pizza(int id, int numberIngredients, List<String> ingredients) {
		super();
		
		Collections.sort(ingredients);
		
		this.id = id;
		this.numberIngredients = numberIngredients;
		this.ingredients = ingredients;
		
		this.ingredientsString = String.join(Constants.DOT, ingredients);
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getNumberIngredients() {
		return numberIngredients;
	}
	
	public void setNumberIngredients(int numberIngredients) {
		this.numberIngredients = numberIngredients;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public String getIngredientsString() {
		return ingredientsString;
	}

	public void setIngredientsString(String ingredientsString) {
		this.ingredientsString = ingredientsString;
	}
	
	
}
