package com.labs11;

import java.util.Scanner;

public class SymbolStackFrontEnd {

    public static void main(String[] args) {
	System.out.println("Enter a word to check the syntax");
	Scanner s = new Scanner(System.in);
	
	String input = s.nextLine();
	System.out.println(isValidSyntax(input));
	
	
	
    }
    public static boolean isValidSyntax(String input) {
	SymbolStack stack = new SymbolStack();
	char[] chars = input.toCharArray();
	for(int i = 0 ; i < chars.length; i++) {
	    char c = chars[i];
	    
	    String cString1 = c+"";
	    
	    
	    SymbolPair pair = stack.isStart(cString1);
	 
	    if(pair != null && !stack.contains(pair)) {
		stack.push(pair); 
		
		
	    }else if(stack.contains(pair) ){
		stack.pop();
	    }
	    
	   
	}
	
	if(stack.remains()) {
	    return false;
	}else {
	    return true;
	}
    }

}
