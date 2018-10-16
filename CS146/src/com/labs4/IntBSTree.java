package com.labs4;

import java.util.Arrays;

public class IntBSTree {

	protected int[] array;
	protected int size;

	public IntBSTree() {
		array = new int[10000];
		Arrays.fill(array, -1);
		size = 0;
	}

	public void insert(int value) {
		if(value<0) return;
		if(array[0]<0){
			array[0]=value;
		}else{
			insertNode(0,value);
		}
	}
	public void insertNode(int rootIndex, int value){
		if(rootIndex>array.length-1 || value<1) return;
		if(array[rootIndex]==-1){
			array[rootIndex]=value;
		}else if(value<array[rootIndex]){
			insertNode(leftIndex(rootIndex),value);
		}else{
			insertNode(rightIndex(rootIndex),value);
		}
		
	}
	public boolean isEmpty() {
		return size == 0;
	}

	public int leftIndex(int i) {
		return i * 2 + 1;
	}

	public int rightIndex(int i) {
		return i * 2 + 2;
	}

	public int parent(int i) {
		return array[parentIndex(i)];
	}

	public int parentIndex(int i) {
		return i / 2;
	}
	public void printInOrder(){
		inOrder(0);
	}
	public void inOrder(int i){
		if(i>=array.length-1) return;
		inOrder(leftIndex(i));
		if(array[i]>-1){
			System.out.println(array[i]);
		}
		inOrder(rightIndex(i));
	}
	public int getDepth(int rootIndex,int value,int curDepth){
		if (array[rootIndex] == value) {
			return curDepth;
		} else if (value > array[rootIndex]) {

			return getDepth(rightIndex(rootIndex), value, curDepth + 1);
		} else if (value < array[rootIndex]) {
			return getDepth(leftIndex(rootIndex), value, curDepth + 1);
		} else {
			return -1;
		}
	}
	public void printBreadthOrder() {
		for (int i : array) {
			if(i>-1){
				System.out.println(i);
			}
			
		}
	}

}