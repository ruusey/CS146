package com.hw2;

import java.util.Scanner;

public class ShapeFrontEnd {
	public static void main(String[] args) {
		ShapeCollection c = new ShapeCollection();
		Scanner s = new Scanner(System.in);

		System.out.println("Welcome to the Shapes collections");

		while (true) {
			printMenu();
			int choice = s.nextInt();
			s.nextLine();
			if (choice == 1) {
				printShapeChoice();
				String shapeChoice = s.nextLine();
				if (shapeChoice.equalsIgnoreCase("rectangle")) {
					System.out.println("Enter a length followed by a height");
					String params = s.nextLine();
					String[] values = params.split(" ");
					Rectangle rectangle = new Rectangle(
							Double.parseDouble(values[0]),
							Double.parseDouble(values[1]));
					c.addShape(rectangle);
				} else if (shapeChoice.equalsIgnoreCase("triangle")) {
					System.out.println("Enter a base followed by a height");
					String params = s.nextLine();
					String[] values = params.split(" ");
					Triangle triangle = new Triangle(
							Double.parseDouble(values[0]),
							Double.parseDouble(values[1]));
					c.addShape(triangle);
				} else if (shapeChoice.equalsIgnoreCase("circle")) {
					System.out.println("Enter a radius");
					double radius = s.nextDouble();
					Circle circle = new Circle(radius);
					c.addShape(circle);
				}
				c.sortShapes();
				c.printShapes();

			} else if (choice == 2) {
				System.out.println("Enter the shape type");
				String type = s.nextLine();
				System.out.println("Enter the area");
				double area = s.nextDouble();
				c.removeShape(area, type);
				c.printShapes();
			} else {
				System.out.println("Good Bye");
				s.close();
				break;
			}

		}

	}

	public static void printMenu() {
		System.out.println("Enter 1: Add a shape");
		System.out.println("Enter 2: Remove a shape");
		System.out.println("Enter 9: Quit");
	}

	public static void printShapeChoice() {
		System.out.println("What type of shape?");
		System.out.println("Rectangle Triangle or Circle?");

	}
}
