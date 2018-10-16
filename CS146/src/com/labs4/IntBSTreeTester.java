package com.labs4;

public class IntBSTreeTester {
	
	public static void main(String[] args){
		int[] insert = {5,3,9,4,7,2,6,1};
		IntBSTree tree = new IntBSTree();
		for(int i:insert){
			
			tree.insert(i);
		}
		System.out.println("Inserting Values 1-10... Printing In Order...");
		tree.printInOrder();
		System.out.println("Printing Breadth Order...");
		tree.printBreadthOrder();
		System.out.println("Printing the depth of the value 2...");
		System.out.println("depth: "+tree.getDepth(0,2,0));
		System.out.println("Inserting Value: 7... Printing In Order...");
		tree.insert(7);
		tree.printInOrder();
		System.out.println("Inserting Value: 50... Printing In Order...");
		tree.insert(50);
		tree.printInOrder();
		
	}	
}
