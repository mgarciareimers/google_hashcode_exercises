package evenMorePizza.commons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Data;
import models.Pizza;

public class Utils {		
	// Method that reads the file.
	public static Data readFile(String filePath) {
		Data data = new Data();
		
		try {
			String [] fileData; // Array of strings that contains the different cells.
			
			// Open the file and read it.
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			
			// Read the next line;
			System.out.println("> Reading first line...");
			fileData = bufferedReader.readLine().split(Constants.ONE_SPACE);
			
			// Number of pizzas.
			data.setNumberPizzas(Integer.parseInt(fileData[0]));
			
			// Teams.
			data.setTeams2(Integer.parseInt(fileData[1]));
			data.setTeams3(Integer.parseInt(fileData[2]));
			data.setTeams4(Integer.parseInt(fileData[3]));
			
			// Pizzas.
			List<Pizza> pizzas = new ArrayList<>();
			
			for (int i = 0; i < data.getNumberPizzas(); i++) {
				String[] pizzaData = bufferedReader.readLine().split(Constants.ONE_SPACE);
				int numberIngredients = Integer.parseInt(pizzaData[0]);
				List<String> ingredients = new ArrayList<>();
				
				for (int j = 1; j <= numberIngredients; j++) {
					ingredients.add(pizzaData[j]);
				}
				
				pizzas.add(new Pizza(i, numberIngredients, ingredients));
			}
			
			// Sort pizzas by number of ingredients + ingredients alph.
			Collections.sort(pizzas, new Comparator<Pizza>() {
				@Override
				public int compare(Pizza p1, Pizza p2) {
					Integer p1NumberIngredients = p1.getNumberIngredients();
					Integer p2NumberIngredients = p2.getNumberIngredients();
					
					int ingredientsCompare = p1NumberIngredients.compareTo(p2NumberIngredients);
					
					if (ingredientsCompare != 0) {
						return ingredientsCompare;
					}
					
					return p1.getIngredientsString().compareTo(p2.getIngredientsString());
				}
			});
			
			data.setPizzas(pizzas);
			
			// Close the file.
			bufferedReader.close();
			
			return data;
		} catch (IOException e) {
			System.out.println("> Error while reading the input file: " + e);
			return null;
		}
	}
	
	// Method that writes the output file, creating it previously in case it does not exist.
	public static void writeFile(String filePath) {
		FileWriter file = null;
		PrintWriter printWriter = null;
		
		try {
			// Create the printer.
			file = new FileWriter(filePath);
			printWriter = new PrintWriter(file);
			
			// Create the output.
			String output = Integer.toString(0);
			
			for (int i = 1; i < 10; i++) {
				output = output.concat(Constants.BREAK_LINE).concat(Integer.toString(i));
			}
			
			// Print the output in the file.
			printWriter.print(output);
		} catch (IOException e) {
			System.out.println("> Error while writing the output file: " + e);
		} finally {
			try {
				printWriter.close();
				file.close();
				System.out.println("> Output file has been written!");
			} catch (IOException e) {
				System.out.println("> Error while closing the output file: " + e);
			}
		}
	}
}
