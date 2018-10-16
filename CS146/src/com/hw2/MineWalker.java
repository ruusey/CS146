package com.hw2;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Robert Usey
 *
 */
public class MineWalker {
	private static final int BOARD_SIZE = 10;
	public static Space[][] board;

	public enum Space {
		PLAYER, CONE, MINE, SPACE,
	}

	public static int px = 0;
	public static int py = 0;
	private static boolean gameOver = false;

	public static void main(String[] args) {

		while (!gameOver) {
			board = new Space[BOARD_SIZE][BOARD_SIZE];
			Scanner s = new Scanner(System.in);
			System.out
					.println("Welcome to Mine Walker.  Get the ice cream cone and avoid the mines");

			initializeBoard();
			initializeMines();
			initializeCone();
			initializePlayer();
			while (true) {
				printBoard();
				System.out
						.println("Enter either a -1, 0, or 1 in the X or 9 to quit");
				int choice = s.nextInt();

				int x = 0;
				switch (choice) {
				case 9:
					System.out.println("Bye!");
					System.exit(0);
					break;
				case 1:
					x = 1;
					break;
				case -1:
					x = -1;
					break;
				case 0:
					x = 0;
					break;
				default:
					x = 0;
					break;
				}
				s.nextLine();
				System.out.println("Enter either a -1,0, or 1 in the Y");
				choice = s.nextInt();

				int y = 0;
				switch (choice) {

				case 1:
					y = 1;
					break;
				case -1:
					y = -1;
					break;
				case 0:
					y = 0;
					break;
				default:
					y = 0;
					break;
				}
				s.nextLine();
				// UPDATE THE BOARD WITH THE PLAYERS POSITION

				// IF THE MOVE DOESNT TAKE YOU OFF THE BOARD
				if (isValidMove(px + y, py + x)) {
					board[px][py] = Space.SPACE;
					px = px + y;
					py = py + x;
					// CHECK IF YOU BLOW UP
					if (checkCollisionMines()) {
						System.out.println("BOOM DEAD! Play Again?");
						if (s.nextLine().equalsIgnoreCase("no")) {
							System.exit(0);
						} else {
							break;
						}

					}
					if (checkCollisionCone()) {
						System.out.println("YOU WIN! Play Again?");
						if (s.nextLine().equalsIgnoreCase("no")) {
							System.exit(0);
						} else {
							break;
						}
					}
					// ONLY THEN MOVE THE PLAYER SPACE TO THE NEW LOCATION
					board[px][py] = Space.PLAYER;
				} else {
					System.out.println("INVALID MOVE! TRY AGAIN!");
				}
			}
		}

	}

	public static boolean checkCollisionCone() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				// IF THE PLAYER IS ON THIS SQUARE AND ITS A MINE
				if (board[i][j] == Space.CONE && playerIsAt(i, j)) {
					return true;
				}

			}
		}
		return false;
	}

	public static boolean isValidMove(int x, int y) {
		try {
			Space s = board[x][y];
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean checkCollisionMines() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				// IF THE PLAYER IS ON THIS SQUARE AND ITS A MINE
				if (board[i][j] == Space.MINE && playerIsAt(i, j)) {
					return true;
				}

			}
		}
		return false;
	}

	public static boolean playerIsAt(int x, int y) {
		if (px == x && py == y)
			return true;
		return false;
	}

	public static void initializeBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[j][i] = Space.SPACE;
			}
		}
	}

	public static void initializePlayer() {
		px = 0;
		py = 0;
		board[0][0] = Space.PLAYER;
	}

	public static void initializeMines() {
		Random r = new Random();
		for (int x = 0; x < (BOARD_SIZE * BOARD_SIZE) / 10; x++) {
			boolean success = false;
			while (!success) {
				int xM = r.nextInt(BOARD_SIZE);
				int yM = r.nextInt(BOARD_SIZE);
				if (board[xM][yM] == Space.SPACE) {
					board[xM][yM] = Space.MINE;
					success = true;
				}
			}

		}
	}

	public static void initializeCone() {
		Random r = new Random();
		boolean success = false;
		while (!success) {
			int xM = r.nextInt(BOARD_SIZE);
			int yM = r.nextInt(BOARD_SIZE);
			if (board[xM][yM] == Space.SPACE) {
				board[xM][yM] = Space.CONE;
				success = true;
			}
		}
	}

	public static void printBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				Space s = board[i][j];
				switch (s) {
				case PLAYER:
					System.out.print("X");
					break;
				case SPACE:
					System.out.print("_");
					break;
				case CONE:
					System.out.print("^");
					break;
				case MINE:
					System.out.print("_");
					break;
				}
			}
			System.out.println();
		}

	}
}
