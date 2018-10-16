package com.hw4;

import java.util.Scanner;

public class DoubleLinkedListFrontEnd {
	public static boolean string = false;

	public static void main(String[] args) {
		GenDoubleLinkedList linkedList = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Double Linked List Front End");
		System.out
				.println("Would You Like To Create A List Of Integers Or Strings?");
		System.out.println("1. Strings");
		System.out.println("2. Integers");
		int type = s.nextInt();
		switch (type) {
		case 1:
			string = true;
			linkedList = new GenDoubleLinkedList<String>();
			break;
		case 2:
			linkedList = new GenDoubleLinkedList<Integer>();
			break;
		}

		while (true) {
			printMenu();
			int choice = s.nextInt();
			s.nextLine();
			switch (choice) {
			case 1:
				linkedList.goToNext();
				break;
			case 2:
				linkedList.goToPrev();
				break;
			case 3:
				Object data = linkedList.getDataAtCurrent();
				System.out.println(data);
				break;
			case 4:
				System.out.println("Enter The Data For The Node");
				if (string) {
					String set = s.nextLine();
					linkedList.setDataAtCurrent(set);
				} else {
					Integer set = Integer.parseInt(s.nextLine());
					linkedList.setDataAtCurrent(set);
				}

				break;
			case 5:
				System.out.println("Enter The Data For The Node");
				if (string) {
					String insert = s.nextLine();
					linkedList.insertNodeAfterCurrent(insert);
				} else {
					Integer insert = Integer.parseInt(s.nextLine());
					linkedList.insertNodeAfterCurrent(insert);
				}
				break;
			case 6:
				linkedList.deleteCurrentNode();
				break;
			case 7:
				linkedList.showList();
				break;
			case 8:
				System.out.println("Enter The Data For The Node To Check");

				if (string) {
					String dat = s.nextLine();
					System.out.println("In List: " + linkedList.inList(dat));
				} else {
					Integer dat = Integer.parseInt(s.nextLine());
					System.out.println("In List: " + linkedList.inList(dat));
				}

				break;
			case 9:
				s.close();
				System.exit(0);

			}
		}
	}

	public static void printMenu() {
		System.out.println("Enter The Number Of The Menu Item");
		System.out.println("1. Go To Next Node");
		System.out.println("2. Go To Prev Node");
		System.out.println("3. Get Data At Current");
		System.out.println("4. Set Data At Current");
		System.out.println("5. Insert Node After Current");
		System.out.println("6. Delete Current Node");
		System.out.println("7. Show List");
		System.out.println("8. Check If Data Is In List");
		System.out.println("9. Exit");
	}

}
