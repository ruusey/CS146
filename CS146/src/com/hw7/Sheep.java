package com.hw7;

public class Sheep {
	public String name;
	public int weight;
	public Sheep(String name, int weight){
		this.name=name;
		this.weight=weight;
	}
	@Override
	public String toString(){
		return name+" "+weight;
	}
	
}
