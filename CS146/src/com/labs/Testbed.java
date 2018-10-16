package com.labs;

public class Testbed {
	public static void main(String[] args) {
		String currTime = "10:23";
		
		int index = currTime.indexOf(":");
		int hours = Integer.parseInt(currTime.substring(0,index));
		int min = Integer.parseInt(currTime.substring(index+1,currTime.length()));
		System.out.println("The current time is "+hours+"[hours] "+min+"[min]");
	}
}
