package com.hw8;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class WordFind {
	//CHARACTERS IN THE ALPHABET
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	//LENGTH OF THE ALPHABET
	public static final int LENGTH = 26;
	public static ArrayList<String> DICTIONARY=null;
	//TEST ARRAY
	public static char[][] test={{'r','a','h','j','m'},{'y','u','w','w','k'},{'r','x','n','f','m'},{'q','g','e','e','b'},{'e','o','a','p','e'}};
	public static void main(String[] args){
		//LOAD DICTIONARY WORDS INTO MEMORY
		DICTIONARY=loadDictionary("C://temp//dict.txt");
		//GET RANDOMLY GENERATED CHARACTER DOUBLE ARRAY
		char[][] board = randomCharArray();
		//PRINT THE BOARD
		printBoard(test);
		//SEARCH FOR WORDS STARTING AT EVERY LETTER IN THE ARRAY
		for(int x = 0; x<5;x++){
			for(int y = 0; y<5;y++){
				String cur="";
				System.out.println("Starting at "+x+","+y+" ("+test[x][y]+")");
				wordSearch(x,y,cur,test,0);
			}
		}
	}
	//GENERATES RANDOM CHARACTER ARRAY
	public static char[][] randomCharArray(){
		char[][] result = new char[5][5];
		Random r = new Random();
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				result[i][j]=ALPHABET.charAt(r.nextInt(LENGTH));
			}
		}
		return result;
	}
	//RECURSIVE SEARCH METHOD
	public static  void wordSearch(int x, int y, String curr, char[][] board,int depth){
		//DONT GO OFF THE BOARD!
		if(x<0 || y<0 || x>4 || y>4 || depth>4){
			return;
		}
		//ADD THE CURRENTLY ANALYZED BOARD CHARACTER TO THE STRING
		curr+=board[x][y];
		String s = new String(curr);
		
		boolean inDict = inDictionary(s);
		//ONLY LENGTH 2-5 CHARS
		if(inDict && depth>0){
			System.out.println("Found Word: "+s);
		}
		//SEARCH RECURSELVELY AROUND THE CHARACTER IN ALL 8 DIRECTIONS
		depth=depth+1;
		wordSearch(x-1,y,curr,board,depth);
		wordSearch(x+1,y,curr,board,depth);
		
		wordSearch(x-1,y-1,curr,board,depth);
		wordSearch(x-1,y+1,curr,board,depth);
		
		wordSearch(x+1,y-1,curr,board,depth);
		wordSearch(x+1,y+1,curr,board,depth);
		
		wordSearch(x,y+1,curr,board,depth);
		wordSearch(x,y-1,curr,board,depth);
		
		
	}
	//PRINT THE BOARD OUT
	public static void printBoard(char[][] board){
		for(char[] arr:board){
			for(char c: arr){
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
	//READS A FILE OF ALL LINES STORING THEM IN AN ARRAYLIST, LOWERCASE CONVERSION
	public static ArrayList<String> loadDictionary(String path){
		System.out.println("Loading the dictionary into memory...");
		long startTime = System.currentTimeMillis();
        try {
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(path),
                    Charset.defaultCharset());
            //MAKE ALL LOWERCASE
            for(int x = 0 ; x < lines.size()-1;x++){
            	String temp = lines.get(x);
            	lines.set(x, temp.toLowerCase());
            }
            System.out.println("Dictionary laoded in "+(System.currentTimeMillis()-startTime)+"ms");
           return lines;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public static boolean inDictionary(String s){
		//SAME AS .contains()
		for(String word: DICTIONARY){
			if(s.equals(word)){
				return true;
			}
		}
		return false;
	}
	
}
