package com.hw6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FruitTreeFrontEnd {
	public static final String FILE = "S:\\RU\\CS\\src\\com\\hw6\\fruitFile.txt";
	public static void main(String[] args) {
		Scanner s = null;
		FruitTree tree = new FruitTree();
		System.out.println("Welcome to the fruit tree!");
		try {
			s = new Scanner(new File(FILE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Populating fruit tree from fruits file");
		while (s.hasNextLine()) {
			String line = s.nextLine();
			String[] split = line.split("\t");
			Fruit f = new Fruit(split[0], Double.parseDouble(split[1]));
			tree.insert(f);
			
		}
		System.out.println("Printing the in-order traversal");
		tree.inOrder(tree.getRoot());
		System.out.println();
		System.out.println("Printing the pre-order traversal");
		tree.preOrder(tree.getRoot());
		System.out.println();
		System.out.println("Printing the post-order traversal");
		tree.postOrder(tree.getRoot());
		System.out.println();
		Fruit remove = new Fruit("Apple",0.4859853412170728);
		System.out.println("Removing "+remove.toString());
		tree.delete(tree.getRoot(), remove);
		tree.inOrder(tree.getRoot());
	}
}
