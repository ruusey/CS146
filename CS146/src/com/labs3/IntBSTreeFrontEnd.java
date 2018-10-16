package com.labs3;

public class IntBSTreeFrontEnd {
	public static int[] numbers = {1,8,1,65,2,161,12,1,2,15};
	public static void main(String[] args){
		System.out.println("Testing the tree");
		System.out.println("Inserting 10 Numbers");
		IntBSTree tree = new IntBSTree();
		for(int i : numbers){
			tree.insert(i);
		}
		System.out.println("Printing pre-order traversal");
		tree.printPreorder(tree.root);
		System.out.println("Removing the number 65");
		tree.remove(65);
		tree.printPreorder(tree.root);
		int depthTest = 161;
		System.out.println(tree.find(depthTest));
		System.out.println("The Depth of "+depthTest+" is "+tree.getDepth(tree.root, depthTest, 0));
	}
}
