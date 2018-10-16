package com.labs2;

/**
 * 
 * @author Robert Usey
 * @Linked list implementation of queueing
 * @date 2/3/2017
 */
public class GenLLQueue<T> {
	private ListNode<T> head;
	private ListNode<T> tail;

	public GenLLQueue() {
		super();
		this.head = null;
		this.tail = null;
	}

	public GenLLQueue(ListNode<T> head, ListNode<T> tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public ListNode<T> getTail() {
		return tail;
	}

	public void setTail(ListNode<T> tail) {
		this.tail = tail;
	}

	public void enqueue(T data) {
		ListNode<T> insert = new ListNode<T>(data, null);

		ListNode<T> current = this.getHead();
		if (current == null) {
			this.setHead(insert);
			this.setTail(insert);
		} else {
			while (current != null) {
				if (current.getLink() == null) {
					current.setLink(insert);
					this.setTail(insert);
					current = current.getLink();
				}
				current = current.getLink();
			}
		}

	}

	public T dequeue() {
		ListNode<T> current = this.getHead();
		this.setHead(current.getLink());
		return current.getData();

	}

	public T peek() {
		return head.getData();
	}

	public void showQueue() {
		
		ListNode<T> current = this.getHead();
		while (current != null) {

			System.out.println(current.getData());

			current = current.getLink();
		}
	}
	public void printQueue(){
		ListNode<T> current = this.getHead();
		while (current != null) {
			T i = current.getData();
			String data = "|" + i + "|";
			if(current.equals(this.getHead())){
				data = "|*" + i + "*|";
			}
			for (int y = 0; y < data.length(); y++) {
				System.out.print("-");
			}
			System.out.println();

			System.out.println(data);
			for (int y = 0; y < data.length(); y++) {
				System.out.print("-");
			}
			System.out.println();
			if (current.getLink()!=null) {
				System.out.println("|\n|");
			}

			current = current.getLink();
		}
		
	}

	private class ListNode<T> {
		private T data;
		private GenLLQueue<T>.ListNode<T> link;

		public ListNode() {
			this.data = null;
			this.link = null;
		}

		public ListNode(T data, GenLLQueue<T>.ListNode<T> link) {
			super();
			this.data = data;
			this.link = link;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public GenLLQueue<T>.ListNode<T> getLink() {
			return link;
		}

		public void setLink(GenLLQueue<T>.ListNode<T> link) {
			this.link = link;
		}

	}

}
