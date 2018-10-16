package com.ec;

import java.util.Random;

public class AVLFrontEnd {
	public static void main(String[] args){
		Random r = new Random();
		AVLTree tree = new AVLTree();
		System.out.println("Inserting 20 Random Values Range 0-99 Into the tree!");
		for(int i = 0; i<20;i++){
			tree.insert(r.nextInt(100));
		}
		System.out.println("Printing The Balanced Tree In-Order!");
		tree.printInOrder();
	}
}
