package models;

import java.util.List;

public class Data {
	private int numberPizzas;
	private int teams2;
	private int teams3;
	private int teams4;
	private List<Pizza> pizzas;
	
	public int getNumberPizzas() {
		return numberPizzas;
	}
	
	public void setNumberPizzas(int numberPizzas) {
		this.numberPizzas = numberPizzas;
	}
	
	public int getTeams2() {
		return teams2;
	}
	
	public void setTeams2(int teams2) {
		this.teams2 = teams2;
	}
	
	public int getTeams3() {
		return teams3;
	}
	
	public void setTeams3(int teams3) {
		this.teams3 = teams3;
	}
	
	public int getTeams4() {
		return teams4;
	}
	
	public void setTeams4(int teams4) {
		this.teams4 = teams4;
	}
	
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	
}
