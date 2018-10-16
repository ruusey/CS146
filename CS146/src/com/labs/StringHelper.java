package com.labs;

import java.util.ArrayList;

/**
 * 
 * @author Robert Usey and Tony Bonadio
 *
 */
public class StringHelper {
	public static String[] vowels = { "a", "e", "i", "o", "u" };

	public static String meshStrings(String string1, String string2) {
		StringBuffer buff = new StringBuffer();
		int max = Math.max(string1.length(), string2.length());
		for (int i = 0; i < max; i++) {
			if (i < string1.length()) {
				buff.append(string1.charAt(i));
			}
			if (i < string2.length()) {
				buff.append(string2.charAt(i));
			}
		}
		return buff.toString();
	}

	public static String replaceVowelsWithOodle(String s) {
		ArrayList<String> strings = new ArrayList<String>();
		for (String s1 : s.split("")) {
			strings.add(s1);
		}

		for (int x = 0; x < strings.size(); x++) {
			if (isVowel(strings.get(x))) {
				strings.set(x, "oodle");
			}
		}
		String result = "";
		for (String ss : strings) {
			result += ss;
		}
		return result;
	}

	public static double weight(String s) {
		double result = 0.0;
		for (String str : s.split("")) {
			if (isVowel(str)) {
				result += 2.5;
			} else {
				result += 3.4;
			}
		}
		return result;
	}

	public static boolean isVowel(String test) {
		for (String character : vowels) {
			if (character.equals(test)) {
				return true;
			}
		}
		return false;
	}
}
