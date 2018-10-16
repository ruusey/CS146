package com.hw3;

import java.util.Scanner;

public class ShowcaseGame {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(true){
			Showcase show = new Showcase();
			System.out.println("Welcome to the showcase show down!");
			//System.out.println(show.getShowCaseTotalPrice());
			System.out.println("Your prizes are:");
			show.printRandomPrizes();
			System.out.println("You must guess the total cost of all without going over");
			System.out.println("Enter your guess");
			int guess = s.nextInt();
			s.nextLine();
			System.out.println("You guessed "+guess+" the actual price is "+show.getShowCaseTotalPrice());
			
			if(show.getShowCaseTotalPrice()-guess<=2000 && show.getShowCaseTotalPrice()-guess>0){
				System.out.println("Your guess was under!  You win!");
			}else{
				System.out.println("I'm sorry but that guess was bad.  You lose for being bad.");
			}
			System.out.println("Would you like to play again? Enter 'no' to quit");
			String response = s.nextLine();
			if(response.equalsIgnoreCase("no")){
				System.out.println("Bye");
				break;
			}
		}
		s.close();
		
		
	}
}
