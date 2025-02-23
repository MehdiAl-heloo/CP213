package cp213;

/**
 * @author Mehdi Al-heloo 169063997
 * @version 2025-02-06
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {

	String cleaned = string.replaceAll("[\\s\\d\\p{Punct}]", "").toLowerCase();
	int length = cleaned.length();
	boolean isPalindrome = true;

	for (int i = 0; i < length / 2 && isPalindrome; i++) {

	    if (cleaned.charAt(i) != cleaned.charAt(length - 1 - i)) {
		isPalindrome = false;
	    }
	}
	return isPalindrome;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

	return name.matches("[a-zA-Z_]\\w*") && !name.equals("_");
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {
	String result = word;
	if (!word.isEmpty()) {
	    String wordLower = word.toLowerCase();
	    boolean isUpperCase = Character.isUpperCase(word.charAt(0));
	    String vowels = "aeiouyAEIOUY";
	    StringBuilder consonants = new StringBuilder();
	    int index = 0;
	    boolean vowelFound = false;

	    while (index < wordLower.length() && !vowelFound) {
		char currentChar = wordLower.charAt(index);
		if (vowels.indexOf(currentChar) != -1 && !(index == 0 && currentChar == 'y')) {
		    vowelFound = true;
		} else {
		    consonants.append(word.charAt(index));
		    index++;
		}
	    }

	    if (vowelFound) {
		if (index == 0) {
		    result = word + "way";
		} else {
		    result = word.substring(index) + consonants + "ay";
		}
	    } else {
		result = word + "ay";
	    }

	    if (isUpperCase) {
		result = Character.toUpperCase(result.charAt(0)) + result.substring(1).toLowerCase();
	    }
	}
	return result;
    }
}
