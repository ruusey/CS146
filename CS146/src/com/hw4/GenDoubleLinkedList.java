package com.hw4;

public class GenDoubleLinkedList<T> {
	private ListNode<T> head;
	private ListNode<T> current;

	public GenDoubleLinkedList() {
		super();
		this.head = new ListNode<T>();
		this.current = this.head;
	}

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public ListNode<T> getCurrent() {
		return current;
	}

	public void setCurrent(ListNode<T> current) {
		this.current = current;
	}

	public void goToNext() {
		if (this.getCurrent().getNextLink() != null) {
			this.setCurrent(this.getCurrent().getNextLink());
		}
	}

	public void goToPrev() {
		if (this.getCurrent().getPrevLink() != null) {
			this.setCurrent(this.getCurrent().getPrevLink());
		}
	}

	public T getDataAtCurrent() {
		if (this.getCurrent() != null) {
			return this.getCurrent().getData();
		} else {
			return null;
		}
	}

	public void setDataAtCurrent(T data) {
		if (this.getCurrent() != null) {
			this.getCurrent().setData(data);
		}
	}

	public void insertNodeAfterCurrent(T data) {
		if (this.getCurrent() == null) {
			System.err.println("No current Node");
			return;
		}

		ListNode<T> current = this.getCurrent();

		ListNode<T> nextNode = this.getCurrent().getNextLink();
		ListNode<T> newNode = new ListNode<T>(data, nextNode, current);

		current.setNextLink(newNode);
		if (nextNode != null) {
			nextNode.setPrevLink(newNode);
		}

	}

	public void deleteCurrentNode() {
		if (this.getCurrent().equals(this.getHead())) {
			System.err.println("You cant delete the head!");
			return;
		}

		ListNode<T> lastNode = this.getCurrent().getPrevLink();
		ListNode<T> nextNode = this.getCurrent().getNextLink();
		lastNode.setNextLink(nextNode);
		if (nextNode != null) {
			nextNode.setPrevLink(lastNode);
		}

		if (nextNode != null) {
			this.setCurrent(nextNode);
		} else {
			this.setCurrent(lastNode);
		}

	}

	public void showList() {
		ListNode<T> current = this.getHead();
		while (current != null) {
			String data = "|" + current.getData() + "|";
			if (current.equals(this.getHead())) {
				data = "|*" + current.getData() + "*|";
			}
			if (current.equals(this.getCurrent())) {
				data += " <-";
			}

			for (int x = 0; x < data.length(); x++) {
				System.out.print("-");
			}
			System.out.println();
			System.out.print(data);
			System.out.println();

			for (int x = 0; x < data.length(); x++) {
				System.out.print("-");
			}
			if (current.getNextLink() != null) {
				System.out.println();
				System.out.print("^   |");
				System.out.println();
				System.out.print("|   |");
				System.out.println();
				System.out.print("|   V");
				System.out.println();

			} else {
				System.out.println();
			}

			current = current.getNextLink();

		}
		// System.out.println();
	}

	public boolean inList(T data) {
		ListNode<T> current = this.getHead();
		while (current != null) {
			if (current.getData().equals(data)) {
				return true;
			}
			if (current.getNextLink() != null) {
				current = current.getNextLink();
			}
		}
		return false;
	}
	
	private class ListNode<T> {
		private T data;
		private ListNode<T> nextLink;
		private ListNode<T> prevLink;

		public ListNode(T data, ListNode<T> nextLink, ListNode<T> prevLink) {
			super();
			this.data = data;
			this.nextLink = nextLink;
			this.prevLink = prevLink;
		}

		public ListNode() {
			super();
			this.data = null;
			this.nextLink = null;
			this.prevLink = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public ListNode<T> getNextLink() {
			return nextLink;
		}

		public void setNextLink(ListNode<T> nextLink) {
			this.nextLink = nextLink;
		}

		public ListNode<T> getPrevLink() {
			return prevLink;
		}

		public void setPrevLink(ListNode<T> prevLink) {
			this.prevLink = prevLink;
		}
	}
}
