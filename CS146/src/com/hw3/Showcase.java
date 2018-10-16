package com.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Showcase {
	private Prize[] prizes;
	private Prize[] showCase;
	private int showCaseTotalPrice;
	public static final int SHOWCASE_SIZE=5;
	
	public Showcase() {
		try {
			this.prizes = loadPrices("S:/RU/CS/src/com/hw3/prizeList.txt");
			this.showCase=generateRandomPrizes();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR CREATING SHOWCASE!");
			System.out.println(e.getStackTrace());
		}
	}

	public Prize[] loadPrices(String path) throws FileNotFoundException {
		//ARRAYLIST IMPL TO AVOID HAVING TO COUNT HOW MANY PRIZES THERE WOULD BE
		ArrayList<Prize> prizes = new ArrayList<Prize>();
		File prizeData = new File(path);
		Scanner s = new Scanner(prizeData);
		
		int totalPrizes = 0;
		while (s.hasNextLine()) {
			String line = s.nextLine();
			String[] parts = line.split("\t");
			// DIDNT SPECIFY IF WE STILL NEED TO INCLUDE THE PRIZE IF FORMATTED
			// INCORRECTLY
			if (parts.length < 2)
				continue;
			totalPrizes++;
			String name = parts[0];
			int price = Integer.parseInt(parts[1]);
			prizes.add(new Prize(price, name));

		}
		s.close();
		//TURN IT TO AN ARRAY BASED ON HOW MANY VALID PRIZES WE COUNTED
		return prizes.toArray(new Prize[totalPrizes]);
	}
	public Prize[] generateRandomPrizes(){
		Random r = new Random();
		Prize[] results = new Prize[SHOWCASE_SIZE];
		for(int x = 0; x<SHOWCASE_SIZE;x++){
			int i = r.nextInt(prizes.length);
			results[x]=prizes[i];
			showCaseTotalPrice+=prizes[i].getPrice();
		}
		return results;
	}
	public void printRandomPrizes(){
		if(showCase.length==0) return;
		for(Prize p: showCase){
			System.out.println(p.getName());
		}
	}

	public Prize[] getPrizes() {
		return prizes;
	}

	public void setPrizes(Prize[] prizes) {
		if(prizes==null)return;
		this.prizes = prizes;
	}

	public Prize[] getShowCase() {
		return showCase;
	}

	public void setShowCase(Prize[] showCase) {
		if(showCase==null)return;
		this.showCase = showCase;
	}

	public int getShowCaseTotalPrice() {
		return showCaseTotalPrice;
	}

	public void setShowCaseTotalPrice(int showCaseTotalPrice) {
		if(showCaseTotalPrice<1)return;
		this.showCaseTotalPrice = showCaseTotalPrice;
	}
	
}
