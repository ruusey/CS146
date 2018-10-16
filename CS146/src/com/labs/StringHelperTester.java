package com.labs;

public class StringHelperTester {
	public static void main(String[] args){
		System.out.println("Welcome to the String Helper Tester");
		System.out.println("Testing mesh strings "+StringHelper.meshStrings("hi", "pi"));
		System.out.println("Testing replace vowels with oodle "+StringHelper.replaceVowelsWithOodle("little"));
		System.out.println("Testing string’s weight "+StringHelper.weight("oodle"));
	}
}
