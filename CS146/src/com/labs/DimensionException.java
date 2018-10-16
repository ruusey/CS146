package com.labs;

public class DimensionException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DimensionException(){
		super("Dimensions must be of length one at least");
	}
	public DimensionException(String message){
		super(message);
	}

}
