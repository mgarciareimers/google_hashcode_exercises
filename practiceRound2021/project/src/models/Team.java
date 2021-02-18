package models;

import java.util.List;

public class Team {
	private int peopleNumber;
	private List<Pizza> pizzas;
	
	public Team(int peopleNumber, List<Pizza> pizzas) {
		super();
		
		this.peopleNumber = peopleNumber;
		this.pizzas = pizzas;
	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
}
