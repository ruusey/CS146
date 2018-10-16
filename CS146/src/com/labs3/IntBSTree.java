package com.labs3;


/**
 * 
 * @author Robert Usey
 *
 */
public class IntBSTree {
	public Node root;

	public IntBSTree() {
		this.root = null;
	}
	//INSERT NEW DATA
	public void insert(int data) {
		System.out.println("Inserting " + data);
		Node insert = new Node(data);
		root = insert(root, insert);
	}
	//INSERT
	public Node insert(Node root, Node insert) {
		if (root == null) {
			return insert;
		}
		if (root.equals(insert)) {
			return insert;
		}
		
		if (insert.data < root.data) {
			root.leftChild = (insert(root.leftChild, insert));
		} else {
			root.rightChild = (insert(root.rightChild, insert));
		}

		return root;
	}
	//REMOVE DATA
	public void remove(int data) {
		Node insert = new Node(data);
		root = remove(root, insert);
	}

	public Node remove(Node root, Node toDelete) {
		if (root == null) {
			return null;
		} else if (toDelete.data < root.data) {
			root.leftChild = (remove(root.leftChild, toDelete));
		} else if (toDelete.data > root.data) {
			root.rightChild = (remove(root.rightChild, toDelete));
		} else {
			if (root.leftChild == null) {
				return root.rightChild;
			} else if (root.rightChild == null) {
				return root.leftChild;
			} else {
				Node max = getMax(root.leftChild);
				root.data = max.data;
				root.leftChild = (remove(root.leftChild, root));
			}
		}
		return root;
	}
	//HELPER FOR REMOVE GET RIGHT MOST NODE
	public Node getMax(Node root) {
		while (root.rightChild != null) {
			root = root.rightChild;
		}
		return root;
	}
	//GET DEPTH METHOD
	public int getDepth(Node root, int data, int curDepth) {
		if (!find(data)) {
			return -1;
		}
		if (root.data == data) {
			return curDepth;
		} else if (data > root.data) {

			return getDepth(root.rightChild, data, curDepth + 1);
		} else if (data < root.data) {
			return getDepth(root.leftChild, data, curDepth + 1);
		} else {
			return -1;
		}
	}
	//NODE FIND HELPER METHOD
	public boolean find(int data) {
		Node current = root;
		while (current != null) {
			if (current.data == data) {
				return true;
			} else if (current.data > data) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
		}
		return false;
	}
	//PRINT PREORDER
	public void printPreorder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			printPreorder(root.leftChild);
			printPreorder(root.rightChild);
		}
	}

	private class Node {
		public int data;
		public Node leftChild;
		public Node rightChild;

		public Node(int data) {
			this.data = data;
			leftChild = null;
			rightChild = null;

		}
	}
}
