package com.hw7;

import java.util.Arrays;
import java.util.Comparator;

public class SheepHeapX {
	public int size;
	public Sheep [] heap;
	public int position;
	public SheepHeapX(int size){
		this.size=size;
		heap = new Sheep [size+1];
		position = 0;
	}
	
	public void display(){
		for(int i=1;i<heap.length;i++){
			System.out.print(" " + heap[i]);			
		}
		System.out.println("");
	}
	public void insert(Sheep x){
		if(position==0){
			heap[position+1]=x;
			position = 2;
		}else{
			heap[position++]=x;
			climbUp();
		}
	}
	public void climbUp(){
		int pos = position-1;
		while(pos>0 && (heap[pos/2]!=null && heap[pos]!=null) && heap[pos/2].weight>heap[pos].weight){
			Sheep y = heap[pos];
			heap[pos]=heap[pos/2];
			heap[pos/2] = y;
			pos = pos/2;
		}
	}
	public Sheep removeSheep(){
		Sheep min = heap[1];
		heap[1]=heap[position-1];
		heap[position-1]=null;
		position--;		
		climbDown(1);
		return min;
	}
	
	public void climbDown(int k){
		int a = heap[k].weight;
		int smallest =k;
		if(2*k<position && heap[smallest].weight>heap[2*k].weight){
			smallest = 2*k;
		}
		if(2*k+1<position && heap[smallest].weight>heap[2*k+1].weight){
			smallest = 2*k+1;
		}
		if(smallest!=k){
			swap(k,smallest);
			climbDown(smallest);
		}
				
	}
	public void swap(int a, int b){
		Sheep temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	public void sheepRollCall(){
		for(Sheep s : heap){
			if(s!=null){
				System.out.println(s.toString());
			}
			
		}
	}
	public Sheep[] sheepHeapSort(){
		Sheep[] sort = heap;
		Arrays.sort(sort, new Comparator<Sheep>() {
	        @Override
	        public int compare(Sheep o1, Sheep o2) {
	        	if(o1==null || o2==null){
	        		return 0;
	        	}else{
	        		return o1.weight-o2.weight;
	        	}
	            
	        }
	    });
		return sort;
	}
	
	
		
}