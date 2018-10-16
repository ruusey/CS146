package com.ec;

public class AVLTree {

	private AVLNode root;

	// AVL NODE FOR STORING INT DATA
	private class AVLNode {
		private int data;
		private int balance;
		private int height;
		private AVLNode left;
		private AVLNode right;
		private AVLNode parent;

		AVLNode(int data, AVLNode parent) {
			this.data = data;
			this.parent = parent;
			this.height=0;
		}
		@Override
		public String toString(){
			return "("+this.data+") height: "+this.height+", balance:"+this.balance;
		}
		
	}
	public AVLTree(){
		this.root=null;
		System.out.println("Creating A Self Ballenced AVL Integer Tree!");
	}

	public boolean insert(int value) {
		// IF THERE IS NO DATA IN THE TREE
		if (root == null)
			root = new AVLNode(value, null);
		else {
			AVLNode current = root;
			AVLNode parent;
			while (true) {
				// VALUE ALREADY IN TREE
				if (current.data == value) {
					return false;
				}
				parent = current;

				// LEFT OR RIGHT OF CURRENT
				boolean left = current.data > value;

				if (left) {
					current = current.left;
				} else {
					current = current.right;
				}

				// IF NODE ISLEAF INSERT NEW NODE WITH KEY DATA
				if (current == null) {
					if (left) {
						parent.left = new AVLNode(value, parent);
					} else {
						parent.right = new AVLNode(value, parent);
					}
					// NOW WE MUST BALANCE THE TREE
					balance(parent);
					break;
				}
			}
		}
		return true;
	}

	//SET THE BALANCE FOR TREE STARTING FROM NODE node UPWARDS
	public void balance(AVLNode node) {
		setBalance(node);
		//IF THE TREE IS UNBALANCED LEFTWARDS (MORE THAN 2 HEIGHT DIF)
		if (node.balance == -2) {
			if (getHeight(node.left.left) >= getHeight(node.left.right)){
				node = rotateRight(node);
			}else{
				node = rotateLeftThenRight(node);
			}
				
		//IF THE TREE IS UNBALANCED RIGHTWARDS
		} else if (node.balance == 2) {
			if (getHeight(node.right.right) >= getHeight(node.right.left)){
				node = rotateLeft(node);
			}else{
				node = rotateRightThenLeft(node);
			}
				
		}
		//BALANCE ALL THE WAY UP THE TREE RECURSIVELY
		if (node.parent != null) {
			balance(node.parent);
		} else {
			root = node;
		}
	}

	public AVLNode rotateLeft(AVLNode node) {
		
		AVLNode right = node.right;
		right.parent = node.parent;
		//ROTATE NODES
		node.right = right.left;

		if (node.right != null){
			node.right.parent = node;
		}
		right.left = node;
		node.parent = right;
		//IF THE RIGHT PARENT HAS CHILDREN
		if (right.parent != null) {
			if (right.parent.right == node) {
				right.parent.right = right;
			} else {
				right.parent.left = right;
			}
		}
		//REBALANCE THE NODES AFTER ROTATION
		setBalance(node);
		setBalance(right);
		return right;
	}
	//ROTATE THE RIGHT SUBTREE
	public AVLNode rotateRight(AVLNode node) {

		AVLNode left = node.left;
		left.parent = node.parent;
		//ROTATE NODES TO THE RIGHT
		node.left = left.right;

		if (node.left != null){
			node.left.parent = node;
		}
		left.right = node;
		node.parent = left;
		//IF THE LEFT PARENT HAS CHILDREN
		if (left.parent != null) {
			if (left.parent.right == node) {
				left.parent.right = left;
			} else {
				left.parent.left = left;
			}
		}
		//REBALANCE ROTATED NODES
		setBalance(node);
		setBalance(left);
		return left;
	}
	
	public AVLNode rotateLeftThenRight(AVLNode node) {
		node.left = rotateLeft(node.left);
		return rotateRight(node);
	}

	public AVLNode rotateRightThenLeft(AVLNode node) {
		node.right = rotateRight(node.right);
		return rotateLeft(node);
	}

	public void setBalance(AVLNode node) {
		increaseHeight(node);
		node.balance = getHeight(node.right) - getHeight(node.left);
	}

	public void printInOrder() {
		printInOrder(root);
	}
	//IN ORDER TRAVERSAL
	public void printInOrder(AVLNode node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println(node.toString());
			printInOrder(node.right);
		}
	}
	// ADD ONE TO THE HEIGHT OF THE GREATER HIGHT OF LEFT AND RIGHT CHILDREN
	public void increaseHeight(AVLNode node) {
		if(node!=null){
			if(getHeight(node.left)>getHeight(node.right)){
				node.height=getHeight(node.left)+1;
			}else{
				node.height=getHeight(node.right)+1;
			}
		}
		
	}
	//GET HEIGHT OF NODE
	public int getHeight(AVLNode node) {
        if (node == null)
            return -1;
        return node.height;
    }
}