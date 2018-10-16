package com.hw2;

public class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * (getRadius() * getRadius());
	}

	@Override
	public String getShapeType() {
		// TODO Auto-generated method stub
		return "Circle";
	}

}
