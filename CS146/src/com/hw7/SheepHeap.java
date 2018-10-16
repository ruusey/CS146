package com.hw7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SheepHeap {

	private ArrayList<Sheep> heap;

	public SheepHeap() {

		this.heap = new ArrayList<Sheep>();
	}
	public void sheepRollCall(int start){
		if (start >= heap.size()) {
			return;
		}
		
		sheepRollCall (left(start));
		System.out.println (heap.get(start));
		sheepRollCall (right(start));
	}
	public ArrayList<Sheep> sheepHeapSort(){
		ArrayList<Sheep> temp = heap;
		Collections.sort(temp, new Comparator<Sheep>() {
	        @Override
	        public int compare(Sheep s1, Sheep s2)
	        {
	            return  s1.weight-s2.weight;
	        }
	    });
		return temp;
		
	}
	public void addSheep(Sheep sheep) {
		heap.add(sheep);
		climbUp(heap.size()-1);
	}

	public void climbUp(int n) {
		if (n >= 0 && n < heap.size()){
			while (n > 0 && heap.get(n).weight>heap.get((n-1)/2).weight) {
				swap (n, (n-1)/2);
				n = (n-1)/2;
			}
		}
		
	}

	public void removeSheep() {
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		climbDown(0);
	}

	private void climbDown(int n) {
		int minChildIndex = minChildIndex(n);
		while (minChildIndex != -1 && heap.get(minChildIndex).weight < heap.get(n).weight) {
			swap(minChildIndex, n);
			n = minChildIndex;
			minChildIndex = minChildIndex(n);
		}
	}

	private int right(int i) {

		return 2 * i + 2;
	}

	private int left(int i) {

		return 2 * i + 1;
	}

	private int parent(int i) {
		return i/2;
	}

	private void swap(int i, int j) {
		Sheep temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	private int minChildIndex(int n) {
		if (left(n) > heap.size() - 1) {
			return -1;
		}
		if (right(n) > heap.size() - 1) {
			return left(n);
		}
		if (heap.get(left(n)).weight <= heap.get(right(n)).weight) {
			return left(n);
		} else {
			return right(n);
		}
	}

}