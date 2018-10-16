package com.hw6;

public class FruitTree {
	private Fruit root = null;

	public FruitTree() {
		this.root = null;
	}

	public Fruit getRoot() {
		return root;
	}

	public void setRoot(Fruit root) {
		this.root = root;
	}

	public void insert(Fruit insert) {
		root = insert(root, insert);
	}

	public Fruit insert(Fruit root, Fruit insert) {
		if (root == null) {
			return insert;
		}
		if (root.equals(insert)) {
			return insert;
		}

		if (insert.getWeight() < root.getWeight()) {
			root.setLeft(insert(root.getLeft(), insert));
		} else {
			root.setRight(insert(root.getRight(), insert));
		}

		return root;
	}

	public Fruit delete(Fruit root, Fruit toDelete) {
		if (root == null) {
			return null;
		} else if (toDelete.getWeight() < root.getWeight()) {
			root.setLeft(delete(root.getLeft(), toDelete));
		} else if (toDelete.getWeight() > root.getWeight()) {
			root.setRight(delete(root.getRight(), toDelete));
		} else {
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				Fruit max = getMax(root.getLeft());
				root.setName(max.getName());
				root.setWeight(max.getWeight());
				root.setLeft(delete(root.getLeft(), root));
			}
		}
		return root;
	}

	public Fruit getMax(Fruit root) {
		while (root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}

	public boolean search(Fruit toSearch) {
		return search(root, toSearch);
	}

	private boolean search(Fruit root, Fruit toSearch) {
		if (root == null)
			return false;
		else if (root.equals(toSearch))
			return true;
		else if (toSearch.getWeight() < root.getWeight())
			return search(root.getLeft(), toSearch);
		else
			return search(root.getRight(), toSearch);
	}

	public void inOrder(Fruit root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.println(root.toString());
			inOrder(root.getRight());
		}
	}

	public void preOrder(Fruit root) {
		if (root != null) {
			System.out.println(root.toString());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void postOrder(Fruit root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.toString());
		}
	}
}
