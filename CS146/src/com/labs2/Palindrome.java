package com.labs2;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out
				.println("Enter a word and I will determine if it is a palindrome");
		String word = s.nextLine();
		String palWord = word.toLowerCase().replace(" ", "");
		if (isPalindrome2(palWord)) {
			System.out.println("The word \"" + word + "\" is a palindrome");
		} else {
			System.out.println("The word \"" + word + "\" is NOT palindrome");
		}
		s.close();
	}

	public static boolean isPalindrome(String s) {
		// BASE CASES
		System.out.println(s);
		if (s.length() < 2 || s.equals(null)) {
			return true;
		}

		// IF THE FIRST AND LAST LETTERS MATCH
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			String sub = s.substring(1, s.length() - 1);

			// PERFORM THE SAME OPERATION BUT ON THE SAME STRING BUT WITH THE
			// MATCHING LETTERS REMOVED
			return isPalindrome(sub);
		}
		// IF THE CHARS ARE NOT EQUAL THERE IS NO PALINDROME
		return false;
	}

	public static boolean isPalindrome2(String s) {
		// BASE CASES
		boolean result = false;
		while (true) {
			System.out.println(s);
			if (s.length() < 2 || s.equals(null)) {
				result = true;
				break;
			}
			if (s.charAt(0) == s.charAt(s.length() - 1)) {
				s = s.substring(1, s.length() - 1);
			} else {
				result=false;
				break;
			}

		}
		return result;

	}
}
