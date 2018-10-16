package com.labs3;

import java.util.Random;
import java.util.Scanner;

public class Sorting {
	public static void main(String[] args) {
		Random r = new Random();
		
		for (int x = 0; x < 20; x++) {
			int[] array = generate();
			int search = array[r.nextInt(1000)];
			int lAttempts = linearSearch(array, search);
			int bAttempts = binarySearch(array, search);
			System.out.println("Linear Checks: " + lAttempts);
			System.out.println("Binary Checks: " + bAttempts);
			System.out.println();
		}

	}

	public static int[] generate() {
		int c;
		int[] array;
		array = new int[1000];
		Random r = new Random();

		for (c = 0; c < 1000; c++) {
			array[c] = r.nextInt(1000);
		}
		// SORT ASCENDING
		int temp = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = i + 1; j < 1000; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

		return array;

	}

	public static int linearSearch(int[] array, int search) {
		int c = 0;
		int attempts = 0;
		System.out.println("Searching for "+search+" using linear search ");
		for (c = 0; c < 1000; c++) {
			if (array[c] == search) {
				System.out.println("Found!");
				return attempts;
			}
			attempts++;
		}
		if (c == 999) {
			System.out.println("Not Found");
			return attempts;
		}
		return attempts;

	}

	public static int binarySearch(int[] array, int search) {
		System.out.println("Searching for "+search+" using binary search ");
		int low = 0;
		int high = array.length - 1;
		int attempts = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == search) {
				System.out.println("Found!");
				return attempts;
			} else if (array[mid] < search)
				low = mid + 1;
			else
				high = mid - 1;
			attempts++;
		}

		System.out.println("Not Found!");
		return attempts;

	}
}
