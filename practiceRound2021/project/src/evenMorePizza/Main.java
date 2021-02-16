package evenMorePizza;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import evenMorePizza.commons.Constants;
import evenMorePizza.commons.Utils;

/************************************************************************************************************************
 * * Hello World, * * to start, select the file you want to read from the list
 * of files that appear in the console (type the number of the * element). These
 * files are the ones placed in the "in" folder. Once you run the program, an
 * output file with the same * name will be created in the "out" folder. We hope
 * you like the program. * * Cheers, * * SM-1234 team. * *
 ***********************************************************************************************************************/

public class Main {
	private final static String USER_DIR = "user.dir";
	private final static String INPUT_DATA_PATH = "/in";
	private final static String OUTPUT_DATA_PATH = "/out";

	private static File inputFile = null;

	public static void main(String[] args) {
		selectInputFile();

		System.out.println("\n> SelectedFile: ".concat(inputFile.getName()));
		System.out.println("\n> Read value: " + Utils.readFile(inputFile.getPath())); // TODO - Delete.
	}

	// Method that asks the user for the file to read and selects it saving it in
	// "inputFile" variable.
	private static void selectInputFile() {
		File[] files = new File(System.getProperty(USER_DIR).concat(INPUT_DATA_PATH)).listFiles();

		if (files == null || files.length <= 0) {
			System.out.println("> No files have been found in folder 'in'.");
			return;
		}

		Arrays.sort(files);

		String text = "> Select the file you want to read (type number):\n";

		for (int i = 0; i < files.length; i++) {
			text = text.concat(Constants.BREAK_LINE).concat("> ").concat(Integer.toString(i + 1).concat(Constants.DOT)
					.concat(Constants.ONE_SPACE).concat(files[i].getName()));
		}

		text = text.concat("\n\n> Enter number (1 - ".concat(Integer.toString(files.length)).concat("): "));

		Scanner input = new Scanner(System.in);
		System.out.print(text);

		try {
			String userInput = input.nextLine();

			inputFile = files[Integer.parseInt(userInput) - 1];
			input.close();
		} catch (Exception e) {
			System.out.println(
					"\n> Please select a valid number (1 - ".concat(Integer.toString(files.length)).concat(").\n"));

			selectInputFile();
		}
	}

}
