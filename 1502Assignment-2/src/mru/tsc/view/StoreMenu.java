package mru.tsc.view;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import mru.tsc.controller.Toys;
import mru.tsc.exceptions.MinMaxException;
import mru.tsc.exceptions.PriceException;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;


public class StoreMenu {
	//file name
	ArrayList<Toys> toys;
	String file;
	
	/**
	 * Class constructor
	 * Hold the new file
	 * @param file the current file
	 */
	public StoreMenu(String file) {
		toys = new ArrayList<>();
		this.loadData(file);
		this.file = file;
	}
	
	/**
	 * Method that loads the table
	 * @param file the current file
	 */
	public void loadData(String file) {
			
		//declare variables
		String serialNumber = "";
		String line = "";
		String name = "";
		String brand = "";
		double price = 0.0;
		int numAvailable = 0;
		String ageAppropriate = "";
		char firstChar = 'a';
		try {
			FileReader myReader = new FileReader(file);
			Scanner in = new Scanner(myReader);
			while (in.hasNext()) {
				line = in.nextLine();
				String [] tokens = line.split(";");
				serialNumber = tokens[0];
				firstChar = serialNumber.charAt(0);
				name = tokens[1];
				brand = tokens[2];
				price = Double.parseDouble(tokens[3]);
				numAvailable = Integer.parseInt(tokens[4]);
				ageAppropriate = tokens[5];
				switch (firstChar) {
				case '0':
				case '1':
					toys.add(new Figures(Long.parseLong(serialNumber), name, brand, price, numAvailable, ageAppropriate, tokens[6].charAt(0)));
					break;
				case '2':
				case '3':
					toys.add(new Animals(Long.parseLong(serialNumber), name, brand, price, numAvailable, ageAppropriate, tokens[6],tokens[7].charAt(0)));
					break;
				case '4':
				case '5':
				case '6':
					toys.add(new Puzzles(Long.parseLong(serialNumber), name, brand, price, numAvailable, ageAppropriate, tokens[6].charAt(0)));
					break;
				case '7':
				case '8':
				case '9':
					toys.add(new BoardGames(Long.parseLong(serialNumber), name, brand, price, numAvailable, ageAppropriate, tokens[6], tokens[7]));
					break;
				default:
					System.out.println("WARNING: Invalid serial number");
				}
			}
			in.close();
		} catch (IOException ex) {
			System.out.println("ERROR: Reading File " + file);
		} catch (Exception e) {
			System.out.println("ERROR: Reading line " + line);
		}
	}
	
	/**
	 * This method is part of the menu which gives user option to either
	 * search for a toy, add a toy, remove a toy, or save and exit.
	 * Will tell user an error if they put invalid choice.
	 * 
	 */
	public void run()  {
		this.printWelcomeMessage();
		Scanner in = new Scanner(System.in);
		int choice = -1;
		while (choice != 4) {
			try {
			this.openingChoice();
			choice = in.nextInt();
			switch (choice) {
				case 1:
					search(in);
					break;
				case 2:
					addToy(in);
					break;
				case 3:
					removeToy(in);
					break;
				case 4:
					exit();
					break;
				default:
					System.out.println("ERROR: Wrong Choice");
			}

		}catch (InputMismatchException ex) {
			System.out.println("ERROR: This is not an integer. Please try again");
			in.nextLine();
		} catch (PriceException nx) {
			System.out.println("ERROR: " + nx.getMessage());
		}
	}
		in.close();
		System.out.println("Thank you");
	}

	
	private void printWelcomeMessage() {
		System.out.println("******************************************");
		System.out.println("*******    WELCOME TO TOY STORE    *******");
		System.out.println("******************************************");
	}
	
	private void openingChoice() {
		System.out.println("\nHow we may help you?\n");
		System.out.println("1) Search Inventory and Purchase Toy");
		System.out.println("2) Add New Toy");
		System.out.println("3) Remove Toy");
		System.out.println("4) Save & Exit");
		System.out.print("\nEnter Option: ");
	}
	
	private void printFindToysMenu() {
		System.out.println("\nFind Toys With:\n");
		System.out.println("1) Serial Number(SN)");
		System.out.println("2) Toy Name");
		System.out.println("3) Type");
		System.out.println("4) Back to Main Menu");
		System.out.print("\nEnter Option: ");
	}
	
	public void printInventory() {
		for (Toys toy: toys) {
			System.out.println(toy);
		}
	}
	
	
	private Toys searchBySN(long sn, boolean purchase, Scanner in, boolean print) {
		for (Toys toy: toys) {
			if (toy.getSerialNo() == sn) {
				if (print) {
					System.out.println("1) " + toy.toString());
				}
				System.out.println("1) " + toy.toString());
				if (purchase) {
					System.out.println("2) Back to Search Menu");
					System.out.print("\n Enter Option Number to Purchase: ");
					int optionNumber = in.nextInt();
					if (optionNumber != 2) {
						this.buyItem(toy);
					}
					System.out.println("\nPress enter to Continue");
					in.nextLine();
				}
				return toy;
			}
		}
		if (print) {
			System.out.println("ERROR: No Toy Found");
		}
		return null;
	}
	
	private void searchByName(String name, Scanner in) {
		boolean found = false;
		int index = 0;
		HashMap<Integer, Toys> result = new HashMap<>();
		for (Toys toy: toys) {
			if (toy.getName().toLowerCase().contains(name.toLowerCase())) {
				index++;
				System.out.println(index + ") " + toy.toString());
				result.put(index, toy);
				found = true;
			}
		}
		if (!found) {
			System.out.println("ERROR: No Toy Found");
		} else {
			index++;
			System.out.println(index + ") Back to Search Menu");
			System.out.print("\nEnter Option Number to Purchase: ");
			int optionNumber = in.nextInt();
			if (result.containsKey(optionNumber)) {
				Toys toy = result.get(optionNumber);
				this.buyItem(toy);
			}
			System.out.println("\nPress Any Key to Continue");
			in.nextLine();
		}
	}
	
	private void buyItem(Toys toy) {
		if (toy.getAvaliableCount() > 0) {
			toy.decrementStock();
			System.out.println("The Transaction Successfully Terminated!!!");
		} else {
			System.out.println("ERROR: Item Out of Stock");
		}
	}
	
	private void searchByType(String type, Scanner in) {
		long min = 0L;
		long max = 0L;
		
		if(type.toLowerCase().equals("animals")) {
			min = 2000000000L;
			max = 4000000000L;
		} else if (type.toLowerCase().equals("figures")) {
			min = 0L;
			max = 2000000000L;
		} else if (type.toLowerCase().equals("puzzles")) {
			min = 4000000000L;
			max = 7000000000L;
		} else if (type.toLowerCase().equals("board games")) {
			min = 7000000000L;
			max = 10000000000L;
		} else {
			System.out.println("ERROR: Type has to be one of animals, figures, puzzles or board games");
			System.out.println("Press any key to continue");
			return;
		}
		boolean found = false;
		int index = 0;
		HashMap<Integer, Toys> result = new HashMap<>();
		for (Toys toy: toys) {
			if (toy.getSerialNo() >= min && toy.getSerialNo() < max) {
				index++;
				System.out.println(index + ") " + toy.toString());
				result.put(index, toy);
				found = true;
			}
		}
		if (!found) {
			System.out.println("ERROR: No Toy Found");
		} else {
			index++;
			System.out.println(index + ") Back to Search Menu");
			System.out.print("\n Enter Option Number to Purchase: ");
			int optionNumber = in.nextInt();
			if (result.containsKey(optionNumber)) {
				Toys toy = result.get(optionNumber);
				this.buyItem(toy);
			}
			System.out.println("\nPress Any Key to Continue");
			in.nextLine();
		}
	}
	
	private void search(Scanner in) {
		int choice = -1;
		while (choice != 4) {
			this.printFindToysMenu();
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter serial number: ");
				searchBySN(Long.parseLong(in.next()), true, in, true);
				break;
			case 2:
				System.out.print("Enter toy name: ");
				searchByName(in.next(), in);
				break;
			case 3:
				in.nextLine();
				System.out.print("Enter toy type: ");
				searchByType(in.nextLine(), in);
				break;
			case 4:
				break;
			default:
				System.out.println("ERROR: Wrong Choice. Try Again.");
				break;
			}
			in.nextLine();
		}
	
	}
	
	private void addToy(Scanner in) throws PriceException {
		in.nextLine();
		System.out.print("Enter Serial Number: ");
		String serialNumber = in.nextLine();
		long sn = 0L;
		try {
			sn = Long.parseLong(serialNumber);
			if (searchBySN(sn, false, in, false) != null) {
				System.out.println("ERROR: A toy with this serial number already exists.");
				return;
			}
			if (sn > 9999999999L || sn < 1000000000L) {
				System.out.println("ERROR: Serial number can only be 10 digits long.");
				return;
			}
		} catch (NumberFormatException ex) {
			System.out.println("ERROR: The serial number should only contain digits.");
			return;
		}
		
		System.out.print("Enter Toy Name: ");
		String name = in.nextLine();
		System.out.print("Enter Toy Brand: ");
		String brand = in.nextLine();
		System.out.print("Enter Toy Price: ");
		Double price = Double.parseDouble(in.nextLine());
		if (price < 0) {
			throw new PriceException("Price can not be negative");
		}
		System.out.print("Enter Available Count: ");
		Integer count = Integer.parseInt(in.nextLine());
		System.out.print("Enter Age Appropriate: ");
		String ageAppropriate = in.nextLine();
		char firstChar = serialNumber.charAt(0);
		try {
			switch (firstChar) {
				case '0':
				case '1':
					System.out.print("Enter the figure classification, The classification can either be Action, Doll, or Historic: ");
					toys.add(new Figures(sn, name, brand, price, count, ageAppropriate, in.nextLine().charAt(0)));
					break;
				case '2':
				case '3':
					System.out.print("Enter material: ");
					String material = in.nextLine();
					System.out.println("Enter size, size can either be Small, Medium or Large: ");
					toys.add(new Animals(sn, name, brand, price, count, ageAppropriate, material, in.nextLine().charAt(0)));
					break;
				case '4':
				case '5':
				case '6':
					System.out.print("Enter puzzle type. The puzzle-type can either be Mechanical, Cryptic, Logic, Trivia, or Riddle: ");
					toys.add(new Puzzles(sn, name, brand, price, count, ageAppropriate, in.nextLine().charAt(0)));
					break;
				case '7':
				case '8':
				case '9':
					System.out.print("Enter minimum number of players: ");
					int min = Integer.parseInt(in.nextLine());
					System.out.print("Enter maximum number of players: ");
					int max = Integer.parseInt(in.nextLine());
					if (max < min) {
						throw new MinMaxException("Maximum number of players can not be smaller than minimum");
					}
					System.out.println("Enter designer name(s), use ',' to separate names: ");
					toys.add(new BoardGames(sn, name, brand, price, count, ageAppropriate, min, max, in.nextLine()));
					break;
				default:
					System.out.println("WARNING: Invalid serial number");
			}
			System.out.println("\n Toy Added.");
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		System.out.println("Press any key to continue");
		in.nextLine();
	}
	
	private void removeToy(Scanner in) throws NumberFormatException {
		in.nextLine();
		System.out.print("Enter Serial Number: ");
		String serialNumber = in.nextLine();
		long sn = 0L;
		try {
			sn = Long.parseLong(serialNumber);
			if (sn > 9999999999L || sn < 1000000000L) {
				System.out.println("ERROR: Serial number can only be 10 digits long.");
				return;
			}
			boolean found = false;
			for (int i = 0; i < toys.size(); i++) {
				Toys toy = toys.get(i);
				if (toy.getSerialNo() == sn) {
					System.out.println("Item Found:");
					System.out.println(toy);
					System.out.println("\n Continue to remove Y/N");
					found = true;
					String remove = in.nextLine().toLowerCase();
					if (remove.equals("Y") || remove.equals("y")) {
						toys.remove(i);
						System.out.println("Item removed");
					}
					else
						break;
				}
			}
			if (!found) {
				System.out.println("Item not found");
			}
			
			System.out.print("Press enter key to continue.");
			in.nextLine();
			
		} catch (NumberFormatException ex) {
			System.out.println("ERROR: The serial number should only contain digits.");
			return;
		}
	}
	
	public void exit() {
		
		try {
		    FileWriter fw = new FileWriter(file);
		    PrintWriter pw = new PrintWriter(fw);
		    for (Toys toy: toys) {
		    	  pw.write(toy.Format() + "\n");
		    }
		    pw.close();
		    System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	    	System.out.println("ERROR: Writing data to file");
	    }
	}
}