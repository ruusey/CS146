package com.hw;

public class Dresser {
	public Clothing[][] clothes = null;

	public Dresser() {
		clothes = new Clothing[5][10];
	}

	public void add(Clothing c) {

		int indexInsertion = 0;
		try {
			for (int x = 0; x < clothes.length; x++) {
				Clothing first = clothes[x][0];
				if (first != null) {
					// IF THERE IS ALREADY A SORTED CLOTHING ARTICLE IN THE
					// DRESSER
					// DRAWER AND THERE IS OPEN SPACE
					if (first.getType().equals(c.getType())) {
						indexInsertion = nextOpenIndex(clothes[x]);
						clothes[x][indexInsertion] = c;
						System.out.println("Added your "+c.toString()+" to the dresser\n");
						return;
					}
				}
				else{
					//OTHERWISE PUT IT IN THE NEXT DRAWER
					int indexToInsert = nextOpenIndex(clothes[x+1]);
					clothes[x][indexToInsert] = (c);
					System.out.println("Added your "+c.toString()+" to the dresser\n");
					return;
				}
			}
			
			//IF THE CLOTHING COULD NOT BE PLACED IN AN EXISTING DRAWER
			//IMPL OF TRY CATCH, ONLY ERROR TO BE THROWN WOULD BE INDEX OUT OF BOUNDS (IF NO ROOM)
		} catch (Exception e) {
			System.out.println("There was no room in the dresser for "+c.toString()+"\n");
			//e.printStackTrace();
		}

	}

	public void remove(Clothing c) {
		for (int x = 0; x < clothes.length; x++) {
			for (int y = 0; y < clothes[x].length; y++) {
				if(clothes[x][y]== null) continue;
				if (clothes[x][y].equals(c)) {
					clothes[x][y] = null;
					System.out.println("Removed your "+c.toString()+" from the dresser\n");
				}

			}
		}
	}
	public static int nextOpenIndex(Clothing[] clothes){
		for(int x = 0 ; x<clothes.length; x++){
			if(clothes[x]==null){
				return x;
			}
		}
		return -1;
		
	}

	public void print() {

		for (int x = 0; x < clothes.length; x++) {
			System.out.println("Drawer " + x);
			if (clothes[x] != null) {
				for (int y = 0; y < clothes[x].length; y++) {

					Clothing item = clothes[x][y];
					if (item != null) {
						System.out.println(item.toString());
					}

				}
			}

			System.out.println();
		}

	}

}
