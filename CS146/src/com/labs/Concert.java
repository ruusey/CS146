package com.labs;

public class Concert {
	private String name;
	private int capacity;
	private int NumberOfTicketsSoldByPhone;
	private int NumberOfTicketsSoldAtVenue;
	private double PriceByPhone;
	private double PriceAtVenue;

	public Concert() {
		this.name = "N/A";
		this.capacity = 0;
		this.NumberOfTicketsSoldByPhone = 0;
		this.NumberOfTicketsSoldAtVenue = 0;
		this.PriceByPhone = 0.0;
		this.PriceAtVenue = 0.0;

	}

	public Concert(String name, int capacity, double priceByPhone,
			double priceAtVenue) {
		super();
		this.name = name;
		this.capacity = capacity;
		PriceByPhone = priceByPhone;
		PriceAtVenue = priceAtVenue;
	}

	public Concert(String name, int capacity, int numberOfTicketsSoldByPhone,
			int numberOfTicketsSoldAtVenue, double priceByPhone,
			double priceAtVenue) {
		super();
		this.name = name;
		this.capacity = capacity;
		NumberOfTicketsSoldByPhone = numberOfTicketsSoldByPhone;
		NumberOfTicketsSoldAtVenue = numberOfTicketsSoldAtVenue;
		PriceByPhone = priceByPhone;
		PriceAtVenue = priceAtVenue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if(capacity<1) return;
		this.capacity = capacity;
	}

	public int getNumberOfTicketsSoldByPhone() {
		return NumberOfTicketsSoldByPhone;
	}

	public void setNumberOfTicketsSoldByPhone(int numberOfTicketsSoldByPhone) {
		NumberOfTicketsSoldByPhone = numberOfTicketsSoldByPhone;
	}

	public int getNumberOfTicketsSoldAtVenue() {
		return NumberOfTicketsSoldAtVenue;
	}

	public void setNumberOfTicketsSoldAtVenue(int numberOfTicketsSoldAtVenue) {
		NumberOfTicketsSoldAtVenue = numberOfTicketsSoldAtVenue;
	}

	public double getPriceByPhone() {
		return PriceByPhone;
	}

	public void setPriceByPhone(double priceByPhone) {
		if(priceByPhone<1) return;
		PriceByPhone = priceByPhone;
	}

	public double getPriceAtVenue() {
		return PriceAtVenue;
	}

	public void setPriceAtVenue(double priceAtVenue) {
		if(priceAtVenue<1) return;
		PriceAtVenue = priceAtVenue;
	}

	public int TotalNumberOfTicketsSold() {
		return this.getNumberOfTicketsSoldByPhone()
				+ this.getNumberOfTicketsSoldAtVenue();
	}

	public int TicketsRemaining() {
		return this.getCapacity() - this.TotalNumberOfTicketsSold();
	}

	public void BuyTicketsAtVenue(int numberOfTickets) {
		if(numberOfTickets<1) return;
		if((TicketsRemaining()-numberOfTickets)<0){
			System.out.println("Sold Out!");
			return;
		}
		
		this.setNumberOfTicketsSoldAtVenue(this.getNumberOfTicketsSoldAtVenue()
				+ numberOfTickets);
	}

	public void BuyTicketsByPhone(int numberOfTickets) {
		if(numberOfTickets<1) return;
		if((TicketsRemaining()-numberOfTickets)<0){
			System.out.println("Sold Out!");
			return;
		}
	
		this.setNumberOfTicketsSoldByPhone(this.getNumberOfTicketsSoldByPhone()
				+ numberOfTickets);

	}

	public double TotalSales() {
		return (this.getNumberOfTicketsSoldAtVenue() * this.getPriceAtVenue())
			+  (this.getNumberOfTicketsSoldByPhone() * this.getPriceByPhone());

	}
	

}
