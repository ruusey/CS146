package com.hw9;

public class Bridge {
	private LandArea one;
	private LandArea two;
	
	public Bridge(LandArea one, LandArea two){
		one.getBridges().add(this);
		two.getBridges().add(this);
		this.one = one;
		this.two = two;
	}
	
	public LandArea getOne() {
		return one;
	}
	public void setOne(LandArea one) {
		this.one = one;
	}
	public LandArea getTwo() {
		return two;
	}
	public void setTwo(LandArea two) {
		this.two = two;
	}
	@Override
	public String toString(){
		return one.getQuadrant()+" --> "+two.getQuadrant();
	}
	
}
