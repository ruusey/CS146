package com.sw;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class SWSort {
    public static final ArrayList<String> queries = new ArrayList<String>();
    public static HashMap<Integer, String> wordCounts = new HashMap<Integer, String>();
    public final static String[] toFind = new String[] {"force", "Wookiee", "Jabba","lightsaber", "Skywalker", "Tatooine", "Bantha", "Wedge", "Death Star"};
    public static void main(String[] args) throws IOException {
	System.out.println("Scanning Star Wars and sorting the words “force”, “wookiee”, “jabba”, ”lightsaber”, “Skywalker”, “Tatooine”, “Bantha”, “Wedge”, “death star”");
	String allText = "";
	File in = new File("src//com//sw//sw.txt");
	BufferedReader br = new BufferedReader(new FileReader(in));

	String st;
	while ((st = br.readLine()) != null) {
	    allText += st;
	}
	   
	
	br.close();
	countWords(allText);
	
    }
    public static void countWords(String text) {
	int fCount = countMatches(text,toFind[0]);
	int wCount = countMatches(text,toFind[1]);
	int jCount = countMatches(text,toFind[2]);
	int lCount = countMatches(text,toFind[3]);
	int sCount = countMatches(text,toFind[4]);
	int tCount = countMatches(text,toFind[5]);
	int bCount = countMatches(text,toFind[6]);
	int weCount = countMatches(text,toFind[7]);
	int dCount = countMatches(text,toFind[8]);
	wordCounts.put(fCount, toFind[0]);
	wordCounts.put(wCount, toFind[1]);
	wordCounts.put(jCount, toFind[2]);
	wordCounts.put(lCount, toFind[3]);
	wordCounts.put(sCount, toFind[4]);
	wordCounts.put(tCount, toFind[5]);
	wordCounts.put(bCount, toFind[6]);
	wordCounts.put(weCount, toFind[7]);
	wordCounts.put(dCount, toFind[8]);
	sortTable();
	
    }
    public static void sortTable() {
	 ArrayList<Integer> v = new ArrayList<Integer>(wordCounts.keySet());
	 Collections.sort(v);
	 for (int str : v) {
	      System.out.println("The number of time the word '"+wordCounts.get(str) + "' appears in Star Wars is " + str );
	    }
    }
    private static int countMatches(String str, String sub) {
	str=str.toLowerCase(); sub=sub.toLowerCase();
	    int count = 0;
	    if(!str.isEmpty() && !sub.isEmpty()) {
	        for (int i = 0; (i = str.indexOf(sub, i)) != -1; i += sub.length()) {
	            count++;
	        }
	    }
	    return count;
    }
    public void sort(int arrA[]) {
        int size = arrA.length;

        // Build heap
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(arrA, size, i);

        // One by one extract (Max) an element from heap and
        // replace it with the last element in the array
        for (int i=size-1; i>=0; i--) {

            //arrA[0] is a root of the heap and is the max element in heap
            int x = arrA[0];
            arrA[0] = arrA[i];
            arrA[i] = x;

            // call max heapify on the reduced heap
            heapify(arrA, i, 0);
        }
    }

    // To heapify a subtree with node i
    void heapify(int arrA[], int heapSize, int i) {
        int largest = i; // Initialize largest as root
        int leftChildIdx  = 2*i + 1; // left = 2*i + 1
        int rightChildIdx  = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftChildIdx  < heapSize && arrA[leftChildIdx ] > arrA[largest])
            largest = leftChildIdx ;

        // If right child is larger than largest so far
        if (rightChildIdx  < heapSize && arrA[rightChildIdx ] > arrA[largest])
            largest = rightChildIdx ;

        // If largest is not root
        if (largest != i) {
            int swap = arrA[i];
            arrA[i] = arrA[largest];
            arrA[largest] = swap;

            // Recursive call to  heapify the sub-tree
            heapify(arrA, heapSize, largest);
        }
    }
}
