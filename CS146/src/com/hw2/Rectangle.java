package com.hw2;

public class Rectangle implements Shape {
	private double length;
	private double height;

	public Rectangle(double length, double height) {
		super();
		this.length = length;
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getHeight() * getLength();
	}

	@Override
	public String getShapeType() {
		// TODO Auto-generated method stub
		return "Rectangle";
	}

}
