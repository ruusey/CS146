package com.labs5;

public class Process {
	private int priority;
	private double time;
	private String name;
	public Process(String name, double time, int priority) {
		if(priority<1 || time<1) return;
		this.priority = priority;
		this.time = time;
		this.name = name;
	}
	@Override
	public boolean equals(Object other){
		Process p = (Process)other;
		return(this.priority==p.priority && this.time==p.time && this.name.equals(p.name));
	}
	@Override
	public String toString(){
		return this.name+" "+this.priority+" "+this.time;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
