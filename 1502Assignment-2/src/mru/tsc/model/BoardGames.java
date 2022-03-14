package mru.tsc.model;

import java.util.ArrayList;
import java.util.Arrays;

import mru.tsc.controller.Toys;

/**
 * this class sets up the board game toy
 * @author Jonah
 *
 */
public class BoardGames extends Toys {

	//declaring the needed parameter
	 	private int min;
	    private int max;
	    
	    //ArrayList for designer
	    private ArrayList<String> designer;
	
	/**
	 * this constructor creates the toy of type figure
	 * @param s is the serial number
	 * @param n is the name of the toy
	 * @param b is the brand of the toy
	 * @param p is the price of the toy
	 * @param aC is the available count of the toy
	 * @param aA is the age appropriate number for the toy
	 * @param material of the animal
	 * @param size of the animal
	 */
	public BoardGames(long s, String n, String b, double p, int aC, String aA, String noOfPlayers, String designer) {
		super(s, n, b, p, aC, aA);
		String [] minMaxPlayers = noOfPlayers.split("-");
        try {
            this.min = Integer.parseInt(minMaxPlayers[0]);
        } catch (NumberFormatException ex) {
            this.min = 0;
        }
        try {
            this.max = Integer.parseInt(minMaxPlayers[1]);
        } catch (NumberFormatException ex) {
            this.max = 0;
        }
        String [] designerList = designer.split(",");
        this.designer = new ArrayList<String>(Arrays.asList(designerList));
	}

	/**
	 * Secondary constroctor for the min and max amount of people
	 *@param s is the serial number
	 * @param n is the name of the toy
	 * @param b is the brand of the toy
	 * @param p is the price of the toy
	 * @param aC is the available count of the toy
	 * @param aA is the age appropriate number for the toy
	 * @param min is the minimum amount of people
	 * @param max is the maximum amount of people
	 * @param designer is the creator of the game
	 */
	public BoardGames(long s, String n, String b, double p, int aC, String aA, int min, int max, String designer) {
		super(s, n, b, p, aC, aA);
		this.min = min;
		this.max = max;
		String [] designerList = designer.split(",");
		this.designer = new ArrayList<String>(Arrays.asList(designerList));
	}
	
	@Override
	/**
	 * Prints the info in the following way
	 */
	public String toString() {
        String res =  "Category: Board Games, " + super.toString() + ", Min Players: " + this.min + 
                ", Max Players: " + this.max + ", Designers: ";
        String designers = String.join(",", this.designer);
        return res + designers;
    }

	  /**
		 * get min
		 * @return the min
		 */
		public int getMin() {
			return min;
		}

		/**
		 * get the max
		 * @return the max
		 */
		public int getMax() {
			return max;
		}

		/**
		 * get designers from the txt
		 * @return the designers
		 */
		public ArrayList<String> getDesigners() {
			return designer;
		}
		@Override
		/**
		 * Formatting for boardgame
		 */
		public String Format() {
			String designers = String.join(",", this.designer);
			return String.format("%s;%d-%d;%s", super.Format(), this.min, this.max, designers);
		}
}
