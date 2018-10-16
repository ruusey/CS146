package com.labs2;

public class QueuesDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing Generic Linked List Queue");
		
		GenLLQueue<Integer> qLLInts = new GenLLQueue();
		qLLInts.enqueue(22);
		qLLInts.enqueue(4);
		qLLInts.enqueue(8);
		qLLInts.enqueue(2);
		qLLInts.printQueue();
		System.out.println("Enqueue'ing 51, 50, 33");
		qLLInts.enqueue(51);
		qLLInts.enqueue(50);
		qLLInts.enqueue(33);
		qLLInts.printQueue();
		System.out.println("Dequeue'ing 3 times");
		qLLInts.dequeue();
		qLLInts.dequeue();
		qLLInts.dequeue();
		qLLInts.printQueue();
		System.out.println("Enqueue'ing 34, 2, 6, 7");
		qLLInts.enqueue(34);
		qLLInts.enqueue(2);
		qLLInts.enqueue(6);
		qLLInts.enqueue(7);
		qLLInts.printQueue();
		
		System.out.println("Dequeue'ing 2 times");
		qLLInts.dequeue();
		qLLInts.dequeue();
		qLLInts.printQueue();
		
		
	}

}