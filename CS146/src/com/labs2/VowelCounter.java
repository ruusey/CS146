package com.labs2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VowelCounter {
	public static final String PATH = "S:/RU/CS/src/com/labs2/blah.txt";
	public static String vowels = "aeiou";

	public static void main(String[] args) {
		File f = new File(PATH);
		Scanner s = null;
		String fullText = "";
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				fullText += line;
			}
			int count = countVowels(fullText);
			System.out.println(f.getName() + " has 'AEIOU' in order exactly "
					+ count + " times.");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + " Change that PATH var dummy!");
		}
	}

	public static int countVowels(String s) {
		int vowelCount = 0;
		// REMOVE WHITESPACE
		s = s.replaceAll("\\s+", "");
		// SINCE WE DONT CARE ABOUT WHAT POTENTIALLY IS BETWEEN EACH VOWEL, GET
		// RID OF IT.
		s = s.replaceAll("[^AaEeIiOoUu]", "");
		// LOOP THROUGH ALL SETS OF 5 CHARS IN THE STRING TO SEE IF ANY ARE IN
		// THE ORDER OF 'AEIOU'
		for (int x = 0; x < s.length(); x++) {
			if (x + 5 > s.length())
				break;
			String compare = s.substring(x, x + 5);
			if (compare.equalsIgnoreCase(vowels)) {
				vowelCount++;
			}
		}
		return vowelCount;
	}
}
