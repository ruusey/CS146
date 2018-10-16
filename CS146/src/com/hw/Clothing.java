package com.hw;

public class Clothing {
	private Type type;
	private Color color;
	
	public Clothing(){
		
	}
	
	public Clothing(Type type, Color color) {
		super();
		this.type = type;
		this.color = color;
	}

	@Override
	public String toString(){
		return this.getType()+" "+this.getColor();
		
	}
	public boolean equals(Clothing other){
		return this.getColor().equals(other.getColor()) && this.getType().equals(other.getType());
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
	
	
}

