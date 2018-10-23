package com.labs3;

public class IntBSTreeFrontEnd {
	public static String[] numbers = {"buzzwigs","ABBREVIATIONS","Cat","food","abovementioned","ABSORBABILITIES","VOLATILITY","I","TWIRLIEST","at"};
	public static void main(String[] args){
		System.out.println("Testing the tree");
		System.out.println("Inserting 10 Numbers");
		IntBSTree tree = new IntBSTree();
		for(String i : numbers){
			tree.insert(i);
		}
		System.out.println("Printing pre-order traversal");
		tree.printPreorder(tree.root);
		System.out.println("Removing the number 65");
		tree.remove("at");
		tree.printPreorder(tree.root);
		String depthTest = "TWIRLIEST";
		System.out.println(tree.find(depthTest));
		System.out.println("The Depth of "+depthTest+" is "+tree.getDepth(tree.root, depthTest, 0));
	}
}
