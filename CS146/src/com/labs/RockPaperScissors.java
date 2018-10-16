package com.labs;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	public static String[] plays = { "Rock", "Paper", "Scissors" };
	public static boolean playAgain = true;
	public static int playerWins = 0;
	public static int compWins = 0;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Rock Paper Scissors!  Best 2 out of 3!");

		while (playAgain) {
			playerWins=0;
			compWins=0;
			while(playerWins <2 && compWins<2){
				System.out.println("Enter \"Rock\", \"Paper\", or \"Scissors\"");
				String choice = s.nextLine();
				if (!validPlay(choice)) {
					System.out.println("Not a valid input! Computer wins");
					compWins++;
					System.out.println("Player has won "+playerWins+" times and the computer has won "+compWins+" times");
					continue;
				} else {
					Random r = new Random();
					String AIChoice = plays[r.nextInt(3)];
					boolean compWin = computerWins(choice, AIChoice);
					if(AIChoice.equalsIgnoreCase(choice)){
						System.out.println(choice + " vs " + AIChoice + "!"
								+ " Tie!");
					}else if (compWin) {
						System.out.println(choice + " vs " + AIChoice + "!"
								+ " Computer Wins!");
						compWins++;
					} else {
						System.out.println(choice + " vs " + AIChoice + "!"
								+ " Player Wins!");
						playerWins++;
					}
					System.out.println("Player has won "+playerWins+" times and the computer has won "+compWins+" times");

				}
			}
			if(compWins>playerWins){
				System.out.println("The Computer Wins!");
			}else{
				System.out.println("The Player wins!");
			}
			System.out.println("Play again? \"Yes\" or \"No\"");
			String res = s.nextLine();
			if(res.equalsIgnoreCase("No")){
				playAgain=false;
			}
			

		}
		System.out.println("Goodbye!");

		s.close();
	}

	public static boolean validPlay(String play) {
		return (play.equalsIgnoreCase("Rock") || play.equalsIgnoreCase("Paper") || play
				.equalsIgnoreCase("Scissors"));
	}

	public static boolean computerWins(String humanChoice, String AIChoice) {
		if (AIChoice.equalsIgnoreCase("Rock")
				&& humanChoice.equalsIgnoreCase("Scissors")) {
			return true;
		} else if (AIChoice.equalsIgnoreCase("Paper")
				&& humanChoice.equalsIgnoreCase("Rock")) {
			return true;
		} else if (AIChoice.equalsIgnoreCase("Scissors")
				&& humanChoice.equalsIgnoreCase("Paper")) {
			return true;
		} else {
			return false;
		}

	}
}
