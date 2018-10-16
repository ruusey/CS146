package com.hw7;

import java.util.ArrayList;

public class SheepHeapFrontEnd {
	public static void main(String[] args){
		SheepHeapX heap = new SheepHeapX(10);
		System.out.println("Adding Sheep to the heap!");
		Sheep s1 = new Sheep("Sam",11);
		Sheep s2 = new Sheep("Pat",18);
		Sheep s3 = new Sheep("Bob",3);
		Sheep s4 = new Sheep("Don",120);
		Sheep s5 = new Sheep("Cam",6);
		Sheep s6 = new Sheep("Rick",99);
		Sheep s7 = new Sheep("Dave",92);
		heap.insert(s1);
		heap.insert(s2);
		heap.insert(s3);
		heap.insert(s4);
		heap.insert(s5);
		heap.insert(s6);
		heap.insert(s7);
		System.out.println("Printing breadth order!");
		heap.sheepRollCall();
		Sheep[] sorted = heap.sheepHeapSort();
		System.out.println("Printing Sheep Sorted heap!");
		for(Sheep s: sorted){
			if(s==null) continue;
			System.out.println(s.toString());
		}
		System.out.println("Removing the top 5 sheep!");
		heap.removeSheep();
		heap.removeSheep();
		heap.removeSheep();
		heap.removeSheep();
		heap.removeSheep();
		sorted = heap.sheepHeapSort();
		for(Sheep s: sorted){
			if(s==null) continue;
			System.out.println(s.toString());
		}
		
		
	}
}
