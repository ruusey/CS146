package com.hw9;

import java.util.ArrayList;

public class Quadrant {
	private ArrayList<Bridge> bridges = new ArrayList<Bridge>();
	private int quadrant;
	
	public Quadrant(int quadrant) {
		this.quadrant = quadrant;
	}
	
	public ArrayList<Bridge> getBridges() {
		return bridges;
	}
	public void setBridges(ArrayList<Bridge> bridges) {
		this.bridges = bridges;
	}
	public int getQuadrant() {
		return quadrant;
	}
	public void setQuadrant(int quadrant) {
		this.quadrant = quadrant;
	}
	
}
