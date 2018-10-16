package com.hw;

import java.util.Scanner;

public class DresserFrontEnd {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Dresser dresser = new Dresser();
		System.out.println("Welcome to the dresser!");
		while (true) {

			System.out.println("Enter 1: to add an item");
			System.out.println("Enter 2: to remove an item");
			System.out.println("Enter 3: to print out the dresser contents");
			System.out.println("Enter 9: to quit");
			int choice = s.nextInt();
			s.nextLine();

			if (choice == 1) {

				System.out.println("Enter the Type");
				printTypes();
				Type t = byStringType(s.nextLine());
				if(t==null){
					System.out.println("Invalid Type!");
					continue;
				}
				System.out.println("Enter the Color");
				printColors();
				Color c = byStringColor(s.nextLine());
				if(c==null){
					System.out.println("Invalid Type!");
					continue;
				}
				Clothing garment = new Clothing(t, c);
				dresser.add(garment);
			} else if (choice == 2) {
				System.out.println("Enter the Type");
				printTypes();
				Type t2 = byStringType(s.nextLine());
				if(t2==null){
					System.out.println("Invalid Type!");
					continue;
				}
				System.out.println("Enter the Color");
				printColors();
				Color c2 = byStringColor(s.nextLine());
				if(c2==null){
					System.out.println("Invalid Type!");
					continue;
				}
				Clothing garment2 = new Clothing(t2, c2);
				dresser.remove(garment2);
			} else if (choice == 3) {
				dresser.print();
			} else if (choice == 9) {
				System.out.println("Goodbye");
				s.close();
				System.exit(0);

			} else {
				System.out.println("Invalid choice");
			}

		}
	}

	public static void printColors() {
		String str = "It may be ";
		for (Color c : Color.values()) {
			str += c + ", ";
		}
		System.out.println(str);
	}

	public static void printTypes() {
		String str = "It may be ";
		for (Type t : Type.values()) {
			str += t + ", ";
		}
		System.out.println(str);
	}

	public static Type byStringType(String type) {
		for (Type t : Type.values()) {
			if (t.name().equalsIgnoreCase(type)) {
				return t;
			}
		}
		return null;
	}

	public static Color byStringColor(String color) {
		for (Color c : Color.values()) {
			if (c.name().equalsIgnoreCase(color)) {
				return c;
			}
		}
		return null;

	}
}
