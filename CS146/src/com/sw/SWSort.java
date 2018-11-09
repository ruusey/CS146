package com.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SWSort {
    // HashMap to store the counts of each word

    public static HashMap<Integer, String> wordCounts = new HashMap<Integer, String>();
    // List of words we are looking for
    public final static String[] toFind = new String[] { "force", "Wookiee", "Jabba", "lightsaber", "Skywalker",
	    "Tatooine", "Bantha", "Wedge", "Death Star" };

    public static void main(String[] args) throws IOException {
	System.out.println(
		"Scanning Star Wars and sorting the words “force”, “wookiee”, “jabba”, ”lightsaber”, “Skywalker”, “Tatooine”, “Bantha”, “Wedge”, “death star”");
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

    // Count the number of occurences for each given word
    public static void countWords(String text) {
	int fCount = countMatches(text, toFind[0]);
	int wCount = countMatches(text, toFind[1]);
	int jCount = countMatches(text, toFind[2]);
	int lCount = countMatches(text, toFind[3]);
	int sCount = countMatches(text, toFind[4]);
	int tCount = countMatches(text, toFind[5]);
	int bCount = countMatches(text, toFind[6]);
	int weCount = countMatches(text, toFind[7]);
	int dCount = countMatches(text, toFind[8]);
	wordCounts.put(fCount, toFind[0]);
	wordCounts.put(wCount, toFind[1]);
	wordCounts.put(jCount, toFind[2]);
	wordCounts.put(lCount, toFind[3]);
	wordCounts.put(sCount, toFind[4]);
	wordCounts.put(tCount, toFind[5]);
	wordCounts.put(bCount, toFind[6]);
	wordCounts.put(weCount, toFind[7]);
	wordCounts.put(dCount, toFind[8]);
	// Sort our hashmap based on its integer counts using Collections.sort
	// 
	sortTable(true);

    }

    // Build a hashmap to keep track of the counts of each word while sorting
    public static void sortTable(boolean sortWithAntiquatedSortingMethod) {
	if (sortWithAntiquatedSortingMethod) {
	    ArrayList<Integer> v = new ArrayList<Integer>(wordCounts.keySet());
	    Integer[] arr = new Integer[v.size()];
	    v.toArray(arr);
	    sort(arr);
	    for (int i : arr) {
		System.out.println(
			"The number of time the word '" + wordCounts.get(i) + "' appears in Star Wars is " + i);
	    }
	} else {
	    ArrayList<Integer> v = new ArrayList<Integer>(wordCounts.keySet());
	    Collections.sort(v);
	    for (int str : v) {
		System.out.println(
			"The number of time the word '" + wordCounts.get(str) + "' appears in Star Wars is " + str);
	    }
	}
    }

    // Count number of matches of word ignoring lower/Upercase within a string
    private static int countMatches(String str, String sub) {
	str = str.toLowerCase();
	sub = sub.toLowerCase();
	int count = 0;
	if (!str.isEmpty() && !sub.isEmpty()) {
	    for (int i = 0; (i = str.indexOf(sub, i)) != -1; i += sub.length()) {
		count++;
	    }
	}
	return count;
    }

    public static void sort(Integer arr[]) {
	int n = arr.length;

	for (int i = n / 2 - 1; i >= 0; i--)
	    heapify(arr, n, i);

	for (int i = n - 1; i >= 0; i--) {
	    int temp = arr[0];
	    arr[0] = arr[i];
	    arr[i] = temp;

	    heapify(arr, i, 0);
	}
    }

    static void heapify(Integer arr[], int n, int i) {
	int largest = i;
	int l = 2 * i + 1;
	int r = 2 * i + 2;

	if (l < n && arr[l] > arr[largest])
	    largest = l;

	if (r < n && arr[r] > arr[largest])
	    largest = r;
	if (largest != i) {
	    int swap = arr[i];
	    arr[i] = arr[largest];
	    arr[largest] = swap;

	    heapify(arr, n, largest);
	}
    }

}
