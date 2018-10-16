package com.hw2;

public class ShapeCollection {
	public static final int MAX_SHAPES = 10;
	public Shape[] shapes = null;

	public ShapeCollection() {
		shapes = new Shape[MAX_SHAPES];
	}

	public void addShape(Shape s) {
		int indexInsert = openIndex();
		if (indexInsert != -1) {
			shapes[indexInsert] = s;
		} else {
			System.out.println("Maximum Shapes Reached!");
		}

	}

	public void sortShapes() {
		if (shapes.length < 2)
			return;
		Shape temp;

		for (int i = 0; i < shapes.length - 1; i++) {

			for (int j = 1; j < shapes.length - i; j++) {
				if (shapes[j - 1] == null || shapes[j] == null)
					continue;
				if (shapes[j - 1].getArea() > shapes[j].getArea()) {
					temp = shapes[j - 1];
					shapes[j - 1] = shapes[j];
					shapes[j] = temp;
				}
			}

		}
	}

	public void removeShape(double d, String s) {
		for (int x = 0; x < shapes.length; x++) {
			Shape shape = shapes[x];
			if (shape.getShapeType().equals(s) && shape.getArea() == d) {
				shapes[x] = null;
			}
		}
	}

	public void printShapes() {
		System.out.println();
		for (Shape s : shapes) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle) s;
				System.out.println("Rectangle Length " + r.getLength()
						+ " Height " + r.getHeight() + " Area " + r.getArea());
			} else if (s instanceof Triangle) {
				Triangle t = (Triangle) s;
				System.out.println("Triangle Base " + t.getBase() + " Height "
						+ t.getHeight() + " Area " + t.getArea());
			} else if (s instanceof Circle) {
				Circle c = (Circle) s;
				System.out.println("Rectangle Radius " + c.getRadius()
						+ " Area " + c.getArea());
			}
		}
		System.out.println();
	}

	public int openIndex() {
		for (int x = 0; x < shapes.length; x++) {
			if (shapes[x] == null)
				return x;
		}
		return -1;
	}
}
