package com.labs11;

public class SymbolPair {
    public String start;
    public String end;
   
    public SymbolPair(String start, String end) {
	super();
	this.start = start;
	this.end = end;
    }
    public boolean equals(SymbolPair other) {
	return start.equals(other.start)&& end.equals(other.end);
    }
    

}
