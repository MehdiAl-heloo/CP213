package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Mehdi Al-heloo 169063997
 * @version 2025-02-06
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

	boolean allDigits = true;

	for (int i = 0; i < str.length() && allDigits; i++) {

	    if (!Character.isDigit(str.charAt(i))) {
		allDigits = false;
	    }
	}
	return allDigits;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {

	return sn.matches("SN/\\d{4}-\\d{3}");

    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
     * a (possibly valid) serial number.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	while (fileIn.hasNextLine()) {
	    String sn = fileIn.nextLine();

	    if (validSn(sn)) {
		goodSns.println(sn);
	    } else {
		badSns.println(sn);
	    }
	}
    }
}
