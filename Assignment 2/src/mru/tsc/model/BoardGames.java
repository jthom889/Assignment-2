package mru.tsc.model;

/**
 * this class sets up the board game toy
 * @author Jonah
 *
 */
public class BoardGames extends Toys {

	//declaring the needed parameter
	private String noOfPlayers;
	private String designer;
	
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
	public BoardGames(int s, String n, String b, double p, int aC, String aA, String noOfPlayers, String designer) {
		super(s, n, b, p, aC, aA);
		this.noOfPlayers = noOfPlayers;
		this.designer = designer;
	}


	/**
	 * getter for material
	 * @return number of players in the game
	 */
	public String getNoOfPlayers() {
		return noOfPlayers;
	}


	/**
	 * setter for material
	 * @param number of players in the game
	 */
	public void setNoOfPlayers(String noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}


	/**
	 * getter for size
	 * @return designer of the game
	 */
	public String getDesigner() {
		return designer;
	}


	/**
	 * setter for size
	 * @param designer 
	 * @param designer of the game
	 */
	public void setDesigner(String designer) {
		this.designer = designer;
	}
}
