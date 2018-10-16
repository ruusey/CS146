package com.labs11;

import java.util.Scanner;

public class StringRecursion {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter two strings and i will see if they are contained within eachother");
	System.out.println("Enter string one");
	String str1 = in.nextLine();
	System.out.println("Enter string two");
	String str2 = in.nextLine();
	if(str1.length()>str2.length()) {
	    System.out.println("Str1 cannot be longer than Str2");
	}else {
	    System.out.println(contains(str1,str2));
	}
    }
    public static boolean contains(String str1, String str2) {
	if(str1.length()==0) return true;
	char c = str1.charAt(0);
	if(str2.indexOf(c)>-1) {
	    return contains(str1.substring(1),str2);
	}else {
	    return false;
	}
	
    }

}
