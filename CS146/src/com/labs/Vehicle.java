package com.labs;

public class Vehicle {
	private String manufacturer;
	private int cylinders;
	private String owner;

	public Vehicle(String manufacturer, int cylinders, String owner) {
		super();
		this.manufacturer = manufacturer;
		this.cylinders = cylinders;
		this.owner = owner;
	}

	public Vehicle() {
		super();
		this.manufacturer = "none";
		this.cylinders = 0;
		this.owner = "none";
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		if (manufacturer == null)
			return;
		this.manufacturer = manufacturer;
	}

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		if (cylinders < 1)
			return;
		this.cylinders = cylinders;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		if (owner == null)
			return;
		this.owner = owner;
	}

}
