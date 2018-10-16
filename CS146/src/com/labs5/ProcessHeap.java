package com.labs5;

import java.util.ArrayList;

public class ProcessHeap {

	public ArrayList<Process> list;
	private int maxSize;

	public ProcessHeap(int maxSize) {
		this.list = new ArrayList<Process>();
		this.maxSize = maxSize;
	}

	public Process peek() {
		return list.get(0);
	}

	public void printHeap() {
		for (Process p : list) {
			System.out.println(p.toString());
		}
	}

	// INSERT A NEW PROCESS
	public void insert(Process item) {
		if (list.size() == maxSize) {
			System.out.println("The List Is Full!!");
			return;
		}
		list.add(item);
		int last = list.size() - 1;
		int parent = parent(last);
		// BUBBLE UP
		while (parent != last
				&& list.get(last).getPriority() < list.get(parent)
						.getPriority()) {

			swap(last, parent);
			last = parent;
			parent = parent(last);
		}
	}

	// REMOVE THE FIRST PROCESS IN THE LIST AND BUBBLE
	public Process remove() {
		if (list.size() == 1) {
			Process min = list.remove(0);
			return min;
		}
		// GET THE HEAD
		Process min = list.get(0);
		// GET THE LAST ITEM
		Process lastItem = list.remove(list.size() - 1);
		// SET HEAD TO LAST ITEM
		list.set(0, lastItem);
		// BUBBLE LIST TO MAINTAIN PROPERTIES
		bubble(0);
		return min;
	}

	public void bubble(int i) {

		int left = left(i);
		int right = right(i);
		int min = -1;
		// MIND CHILD ON THE LEFT SIDE OF CURRENT
		if (left <= list.size() - 1
				&& list.get(left).getPriority() < list.get(i).getPriority()) {
			min = left;
		} else {
			min = i;
		}
		// MIN CHILD ON THE RIGHT SIDE OF CURRENT
		if (right <= list.size() - 1
				&& list.get(right).getPriority() < list.get(min).getPriority()) {
			min = right;
		}
		// PARENT/CHILD OUT OF ORDER NEED TO SWAP THEM
		if (min != i) {
			swap(i, min);
			bubble(min);
		}
	}

	// IF THE LIST IS EMPTY
	public boolean isEmpty() {

		return list.size() == 0;
	}

	// GET THE RIGHT CHILD INDEX
	public int right(int i) {

		return 2 * i + 2;
	}

	// GET THE LEFT CHILD INDEX
	public int left(int i) {

		return 2 * i + 1;
	}

	// GET THE PARENT INDEX
	public int parent(int i) {

		if (i % 2 == 1) {
			return i / 2;
		}

		return (i - 1) / 2;
	}

	// SWAP HELPER METHOD
	public void swap(int one, int two) {

		Process temp = list.get(two);
		list.set(two, list.get(one));
		list.set(one, temp);
	}

}