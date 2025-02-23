package cp213;

import java.util.Scanner;

/**
 * Class to demonstrate the use of Scanner with a keyboard and File objects.
 *
 * @author Mehdi Al-heloo
 * @version 2025-01-23
 */
public class ScannerTest {

    /**
     * Count lines in the scanned file.
     *
     * @param source Scanner to process
     * @return number of lines in scanned file
     */
    public static int countLines(final Scanner source) {
	int count = 0;

	while (source.hasNextLine()) {
	    source.nextLine();
	    count++;
	}

	return count;
    }

    /**
     * Count tokens in the scanned object.
     *
     * @param source Scanner to process
     * @return number of tokens in scanned object
     */
    public static int countTokens(final Scanner source) {
	int tokens = 0;

	while (source.hasNext()) {
	    source.next();
	    tokens++;
	}

	return tokens;
    }

    /**
     * Ask for and total integers from the keyboard.
     *
     * @param source Scanner to process
     * @return total of positive integers entered from keyboard
     */
    public static int readNumbers(final Scanner keyboard) {
	int total = 0;

	System.out.println("Enter positive integers to total. Enter 'q' to quit:");

	while (keyboard.hasNext()) {
	    if (keyboard.hasNextInt()) {
		int number = keyboard.nextInt();

		if (number >= 0) {
		    total += number;
		} else {
		    System.out.println("Negative numbers are ignored.");
		}
	    } else {
		String input = keyboard.next();

		if (input.equalsIgnoreCase("q")) {
		    break;
		} else {
		    System.out.printf("'%s' is not an integer or 'q'.%n", input);
		}
	    }
	}
	return total;

    }
}
