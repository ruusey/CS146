package com.hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Robert Usey
 *
 */
public class PostFixMath {
	// Check out the debug! its pretty cool!
	public static final boolean DEBUG = true;
	public static final String PATH = "C://temp//equations.txt";

	public static void main(String[] args) {
		ArrayList<String> equations = null;
		try {
			equations = readFile(new File(PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (String equation : equations) {
			System.out.println("Calculating " + equation);
			ArrayList<Integer> result = parseEquation(equation);
			if (result.size() > 1) {
				System.out.println("Ill formatted Post Fix Equation");
			} else {
				System.out.println("Result: " + result.get(0));
			}
		}

	}

	public static ArrayList<Integer> parseEquation(String s) {
		ArrayList<Integer> equation = new ArrayList<Integer>();

		for (String part : s.split(" ")) {
			if (part.matches("[+-/*–]")) {
				if (equation.size() > 1) {
					equation = condensePostFix(equation, part);
					if (equation == null) {
						break;
					}
					if (DEBUG) {
						System.out.println("--------------------------");
						System.out.println("~~~~RESULTANT EQUATION~~~~~");
						System.out.println("--------------------------");

						printEquation(equation);
					}

				} else {
					System.out.println("Ill formatted Post Fix Equation");
					break;
				}

			} else if (part.matches("[0-9]+")) {
				equation.add(Integer.parseInt(part));

			} else {
				System.out.println("Invalid Input Character " + part + "!");
				break;
			}
		}

		return equation;
	}

	public static ArrayList<Integer> condensePostFix(
			ArrayList<Integer> equation, String operand) {
		if (DEBUG) {
			System.out.println("Performing " + operand + " On:");
			printEquation(equation);
		}

		if (operand.equals("-") || operand.equals("–")) {
			//FIND THE LAST AND SECOND TO LAST VALUES OF THE LIST
			//APPLY THE OPERAND, REMOVE LAST ELEMENT, MOVE NEW DATA INTO NEW LAST ELEMENT.
			int one = equation.get(equation.size() - 2);
			int two = equation.get(equation.size() - 1);
			equation.remove(equation.size() - 1);
			equation.set(equation.size() - 1, one - two);

		} else if (operand.equals("+")) {
			int one = equation.get(equation.size() - 2);
			int two = equation.get(equation.size() - 1);
			equation.remove(equation.size() - 1);
			equation.set(equation.size() - 1, one + two);

		} else if (operand.equals("*")) {

			int one = equation.get(equation.size() - 2);
			int two = equation.get(equation.size() - 1);
			equation.remove(equation.size() - 1);
			equation.set(equation.size() - 1, one * two);

		} else if (operand.equals("/")) {

			int one = equation.get(equation.size() - 2);
			int two = equation.get(equation.size() - 1);
			if (two == 0) {
				System.out.println("Cannot divide by 0");
				return null;
			}
			equation.remove(equation.size() - 1);
			equation.set(equation.size() - 1, one / two);

		} else {
			System.out.println("Malformed Input Equation");
			return null;
		}
		return equation;
	}

	public static ArrayList<String> readFile(File f)
			throws FileNotFoundException {
		ArrayList<String> equations = new ArrayList<String>();
		Scanner s = new Scanner(f);
		while (s.hasNextLine()) {
			equations.add(s.nextLine());
		}
		s.close();
		return equations;
	}

	public static void printEquation(ArrayList<Integer> equation) {
		for (int x = 0; x < equation.size(); x++) {
			int i = equation.get(x);
			String data = "|" + i + "|";

			for (int y = 0; y < data.length(); y++) {
				System.out.print("-");
			}
			System.out.println();

			System.out.println(data);
			for (int y = 0; y < data.length(); y++) {
				System.out.print("-");
			}
			System.out.println();
			if (x != equation.size() - 1) {
				System.out.println("|\n|");
			}

		}

	}
}
