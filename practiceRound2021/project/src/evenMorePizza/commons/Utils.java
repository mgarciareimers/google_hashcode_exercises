package evenMorePizza.commons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Utils {		
	// Method that reads the file.
	public static Map<String, String> readFile(String filePath) {
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			String [] data; // Array of strings that contains the different cells.
			
			// Open the file and read it.
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			
			// Read the next line;
			System.out.println("> Reading first line...");
			data = bufferedReader.readLine().split(Constants.ONE_SPACE);
			
			// First value.
			System.out.println("> Reading first value...");
			int firstValue = Integer.parseInt(data[0]);
			map.put("firstValue", Integer.toString(firstValue));
			
			
			// Close the file.
			bufferedReader.close();
			
			return map; // TODO.
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
