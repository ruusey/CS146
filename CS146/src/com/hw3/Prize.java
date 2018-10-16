package com.hw3;

public class Prize {
	private int price;
	private String name;

	public Prize() {
		this.price = 0;
		this.name = "";
	}

	public Prize(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price<1) return;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name==null || name.length()<1) return;
		this.name = name;
	}

}
