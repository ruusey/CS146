package com.labs;

public class Square {
	private int length;

	public Square(int length) {
		super();
		this.length = length;
	}

	public Square() {
		super();
		this.length=1;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) throws DimensionException {
		if(length<1) throw new DimensionException();
		this.length = length;
	}
	
	public void draw(){
		if(getLength()==1){
			System.out.println("*");
		}else{
			for(int x = 0; x<getLength();x++){
				for(int y = 0; y<getLength();y++){
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	public double getArea(){
		return Math.pow(getLength(), 2);
	}
	public double getPerimeter(){
		return 4*getLength();
	}
	
	
		
	
}
