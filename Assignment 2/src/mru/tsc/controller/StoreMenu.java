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
	Scanner keyboard;
	
	public StoreMenu() {
		toys = new ArrayList<Toys>();
		keyboard = new Scanner(System.in);
		
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
	
	public void addToy() {
		
		
		int serial = 0;
		
		//validating serial number
		while (true) {
			System.out.println("Enter Serial Number: ");
		
			//validating the serial and ensuring the serial is unique
			if (keyboard.hasNextInt()) {
				serial = keyboard.nextInt();
				
				int exists = 0;
				
				//Searches through the arrayList for an identical serial number
				for(Toys t: toys) {
					int serialNumber = t.getSerialNo();
					
					//if an identical serial number is found, exit the loop and make them try again
					if(serial == serialNumber) {
						System.out.println("Serial Number Already Exists. Try again");
						break;
					}
					//if it is not found exit the loop
					else {
						exists = 1;
						break;
					}	
				}
				if(exists == 1)
					break;
				
			}
		}
		
		//prompting user for the rest of the variables of toy
		System.out.println("Enter Toy Name: ");
		String name = keyboard.nextLine();
		
		System.out.println("Enter Toy Brand: ");
		String brand = keyboard.nextLine();
		
		double price;
		
		//validating the price input
		while(true) {
			System.out.println("Enter Toy Price: ");
			if(keyboard.hasNextDouble()) {
				price = keyboard.nextDouble();
				break;
			} 
		}
		
		int count;
		
		//validating the price input
		while(true) {
			System.out.println("Enter Avaliable Count: ");
			if(keyboard.hasNextInt()) {
				count = keyboard.nextInt();
				break;
			} 
		}
		
		System.out.println("Enter Appropriate Age: ");
		String age = keyboard.nextLine();
		
		//determining the type of toy and adding it to arrayList
		if (Integer.toString(serial).charAt(0) == '0' || Integer.toString(serial).charAt(0) == '1') {
			System.out.println("Enter Classification: ");
			String classification = keyboard.nextLine();
			
			//creating new object and adding it to toys
			Toys figure = new Figures(serial, name, brand, price, count, age, classification);
			toys.add(figure);
		}
		
		else if (Integer.toString(serial).charAt(0) == '2' || Integer.toString(serial).charAt(0) == '3') {
			System.out.println("Enter Material: ");
			String material = keyboard.nextLine();
			
			System.out.println("Enter Size: ");
			String size = keyboard.nextLine();
			
			//creating new object and adding it to toys
			Toys animal = new Animals(serial, name, brand, price, count, age, material, size);
			toys.add(animal);
			
		}
		
		else if (Integer.toString(serial).charAt(0) == '4' || Integer.toString(serial).charAt(0) == '5' ||
				Integer.toString(serial).charAt(0) == '6') {
			System.out.println("Enter Puzzle Type: ");
			String puzzleType = keyboard.nextLine();
			
			//creating new object and adding it to toys
			Toys puzzle = new Puzzles(serial, name, brand, price, count, age, puzzleType);
			toys.add(puzzle);
			
		}
		
		else if (Integer.toString(serial).charAt(0) == '7' || Integer.toString(serial).charAt(0) == '8' ||
				Integer.toString(serial).charAt(0) == '9') {
			System.out.println("Enter Minimum Number of Players: ");
			String players = keyboard.nextLine();
			
			System.out.println("Enter Maximum Number of Players: ");
			players = players + "-" + keyboard.nextLine();
			
			System.out.println("Enter Designer Names (Use ',' to sepperate the names if there is more than one): ");
			String designers = keyboard.nextLine();
			
			//creating new object and adding it to toys
			Toys bg = new BoardGames(serial, name, brand, price, count, age, players, designers);
			toys.add(bg);
			
			
		}
		
	}
	
	
	
}