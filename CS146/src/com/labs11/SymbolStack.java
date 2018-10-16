package com.labs11;

import java.util.ArrayList;

public class SymbolStack {
    public ArrayList<SymbolPair> symbols = new ArrayList<SymbolPair>();
    public ArrayList<SymbolPair> symbolStack = new ArrayList<SymbolPair>();
    public SymbolStack() {
	symbols.add(new SymbolPair("(",")"));
	symbols.add(new SymbolPair("[","]"));
	symbols.add(new SymbolPair("{","}"));
	symbols.add(new SymbolPair("/","/"));
	symbols.add(new SymbolPair("*","*"));
	
    }
    public boolean contains(SymbolPair pair) {
	for(SymbolPair s: symbolStack) {
	    if(s.equals(pair)) {
		return true;
	    }
	}
	return false;
    }
    public void push(SymbolPair pair) {
	if(symbolStack.size()==100) return;
	symbolStack.add(pair);
    }
    public SymbolPair pop() {
	return symbolStack.remove(symbolStack.size()-1);
    }
    public SymbolPair isStart(String c) {
	for(SymbolPair symbol : symbols) {
	    if(symbol.start.equals(c)) {
		return symbol;
	    }
		
	}
	return null;
    }
    public SymbolPair isEnd(String c) {
	for(SymbolPair symbol : symbols) {
	    if(symbol.end.equals(c)) {
		return symbol;
	    }
		
	}
	return null;
    }
    public boolean remains() {
	return symbolStack.size()>0;
    }
    

}
