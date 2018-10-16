package com.hw9;

public class Bridge {
	private Quadrant one;
	private Quadrant two;
	
	public Bridge(Quadrant one, Quadrant two){
		one.getBridges().add(this);
		two.getBridges().add(this);
		this.one = one;
		this.two = two;
	}
	
	public Quadrant getOne() {
		return one;
	}
	public void setOne(Quadrant one) {
		this.one = one;
	}
	public Quadrant getTwo() {
		return two;
	}
	public void setTwo(Quadrant two) {
		this.two = two;
	}
	@Override
	public String toString(){
		return one.getQuadrant()+" --> "+two.getQuadrant();
	}
	
}
