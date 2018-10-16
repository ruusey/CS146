package com.labs3;

import java.util.Scanner;
/**
 * 
 * @author Robert Usey
 *
 */
public class ContainedWords {
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 2 words.  I will determine if the letters of one is contained in the other");
		String one = s.nextLine();
		String two = s.nextLine();
		if(contained2(one,two)){
			System.out.println("'"+one+"' Is Contained In '"+two+"'");
		}else{
			System.out.println("'"+one+"' Is NOT Contained In '"+two+"'");
		}
		

	}
	public static boolean contained(String one, String two){
		//BASE CASES
		if((one.length()==0 && two.length()==0) || one.length()==0 && two.length()>0){
			return true;
		}
		if(one.length()>two.length()){
			return false;
		}
		//USE INDEX OF TO SEE IF THE STRING CONTAINS THE FIRST CHARACTER OF THE WORD
		int index = two.indexOf(one.charAt(0));
		if(index>-1){
			two.replace(""+one.charAt(0), "");
			one.replace(""+one.charAt(0), "");
			//IF SO, WE CAN REMOVE THE FIRST CHARACTER FROM STRING ONE AND THE MATCHED CHARACTER(s) IN STRING TWO
			
			//RECURSE ON RESULTANT STRING AND REMOVE FIRST CHARACTER FROM STRING ONE
			return contained(one.substring(1),two);
		}
		return false;
		
		
		
			
	}
	public static boolean contained2(String one, String two){
		//BASE CASES
		if((one.length()==0 && two.length()==0) || one.length()==0 && two.length()>0){
			return true;
		}
		if(one.length()>two.length()){
			return false;
		}
		while(one.length()!=0){
			if(two.contains(""+one.charAt(0))){
				two = two.replace(""+one.charAt(0), "");
				one = one.replace(""+one.charAt(0), "");
				
			}else{
				return false;
			}
		}
		return true;
	}
}
