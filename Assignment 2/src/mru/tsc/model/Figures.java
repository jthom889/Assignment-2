package mru.tsc.model;

/**
 * this class sets up the figure toy
 * @author Jonah
 *
 */
public class Figures extends Toys {

	//declaring the needed parameter
	private String classification;
	
	
	/**
	 * this constructor creates the toy of type figure
	 * @param s is the serial number
	 * @param n is the name of the toy
	 * @param b is the brand of the toy
	 * @param p is the price of the toy
	 * @param aC is the available count of the toy
	 * @param aA is the age appropriate number for the toy
	 * @param classification of the figure
	 */
	public Figures(int s, String n, String b, double p, int aC, String aA, String classification) {
		super(s, n, b, p, aC, aA);
		this.classification = classification;
	}


	/**
	 * getter for classification
	 * @return the classification of the figure
	 */
	public String getClassification() {
		return classification;
	}


	/**
	 * setter for classification
	 * @param classification of the figure
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
}
