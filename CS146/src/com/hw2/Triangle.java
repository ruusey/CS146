package com.hw2;

public class Triangle implements Shape {
	private double base;
	private double height;

	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
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
		return 0.5 * (getBase() * getHeight());
	}

	@Override
	public String getShapeType() {
		// TODO Auto-generated method stub
		return null;
	}

}
