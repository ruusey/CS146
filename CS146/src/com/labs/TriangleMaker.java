package com.labs;

import java.util.Scanner;

/**
 * 
 * @author Robert Usey
 *
 */
public class TriangleMaker {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out
				.println("Welcome to Triangle Maker 9000!  Enter the size of the triangle.");
		int size = s.nextInt();
		String as = "";
		System.out.println(as);

		for (int x = 0; x < size; x++) {
			as += "*";
			System.out.println(as);
		}

		for (int y = size - 1; y > 0; y--) {
			as = as.substring(0, y);
			System.out.println(as);
		}

		s.close();

	}
}
