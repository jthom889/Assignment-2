package mru.tsc.model;

/**
 * this class sets up the animal toy
 * @author Jonah
 *
 */
public class Animals extends Toys {

	//declaring the needed parameter
	private String material;
	private String size;
	
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
	public Animals(int s, String n, String b, double p, int aC, String aA, String material, String size) {
		super(s, n, b, p, aC, aA);
		this.material = material;
		this.size = size;
	}


	/**
	 * getter for material
	 * @return material of the animal
	 */
	public String getmaterial() {
		return material;
	}


	/**
	 * setter for material
	 * @param material of the animal
	 */
	public void setMatrial(String material) {
		this.material = material;
	}


	/**
	 * getter for size
	 * @return size of the animal
	 */
	public String getSize() {
		return size;
	}


	/**
	 * setter for size
	 * @param size of the animal
	 */
	public void setSize(String size) {
		this.size = size;
	}
}
