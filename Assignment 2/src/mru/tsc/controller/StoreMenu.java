package mru.tsc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
import mru.tsc.model.Toys;

public class StoreMenu {

	//file name
	final String FILE_PATH = "res/toys.txt";
	ArrayList<Toys> toys;
	
	public StoreMenu() {
		toys = new ArrayList<Toys>();
	}	
		
	
	public void loadData() {
			
		//declare variables
		File playerInfo = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		Scanner fileReader = null;
				
			if(playerInfo.exists()) {
				
				try {
					fileReader = new Scanner(playerInfo);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				//loop that makes lines from file into an arrayList of players
				while(fileReader.hasNextLine()) {
					
					currentLine = fileReader.nextLine();
					splittedLine = currentLine.split(";");
					
					try {
						
					if(splittedLine[0].charAt(0) == 0 || splittedLine[0].charAt(0) == 1){
						Toys figure = new Figures(Integer.parseInt(splittedLine[0]), splittedLine[1],
								splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), 
								splittedLine[5], splittedLine[6]);
						toys.add(figure);
					}
					
					else if(splittedLine[0].charAt(0) == 2 || splittedLine[0].charAt(0) == 3){
						Toys animal = new Animals(Integer.parseInt(splittedLine[0]), splittedLine[1],
								splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), 
								splittedLine[5], splittedLine[6], splittedLine[7]);
						toys.add(animal);
					}
					
					else if(splittedLine[0].charAt(0) == 4 || splittedLine[0].charAt(0) == 5 || splittedLine[0].charAt(0) == 6 ) {
						Toys puzzle = new Puzzles(Integer.parseInt(splittedLine[0]), splittedLine[1],
								splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), 
								splittedLine[5], splittedLine[6]);
						toys.add(puzzle);
					}
					
					else if(splittedLine[0].charAt(0) == 7 || splittedLine[0].charAt(0) == 8 || splittedLine[0].charAt(0) == 9 ) {
						Toys boardGame = new BoardGames(Integer.parseInt(splittedLine[0]), splittedLine[1],
								splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), 
								splittedLine[5], splittedLine[6], splittedLine[7]);
						toys.add(boardGame);
					}
					else {
						System.out.println("Error sorting toys");
					}
					
					}
					catch(ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
						
					}
				}
			}
			else 
				System.out.println("File Not Found"); 
		}
	
	public void exit() {
		
		try {
			//declare variables
			File db = new File(FILE_PATH);
			PrintWriter pw = new PrintWriter(db);
			
			for (Toys t: toys) {
			
				pw.print(t.format());
			}
		pw.close();
		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}