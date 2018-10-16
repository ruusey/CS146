package com.hw6;

public class Fruit {
	private String name;
	private double weight;
	private Fruit left;
	private Fruit right;

	public Fruit(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
		this.left = null;
		this.right = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Fruit getLeft() {
		return left;
	}

	public void setLeft(Fruit left) {
		this.left = left;
	}

	public Fruit getRight() {
		return right;
	}

	public void setRight(Fruit right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return name + " " + weight;

	}

	@Override
	public boolean equals(Object other) {
		Fruit compare = (Fruit) other;
		if (compare.name.equals(this.name) && (compare.weight == this.weight)) {
			return true;
		} else {
			return false;
		}
	}

}
