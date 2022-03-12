package mru.tsc.model;

/**
 * this class is the superclass for all toys
 * @author Jonah Thompson
 *
 */
public abstract class Toys {

	//parameters of the toys object
	private int serialNo;
	private String name;
	private String brand;
	private double price;
	private int avaliableCount;
	private String ageAppropriate;
	 
	
	/**
	 * the constructor for the toys class
	 * @param serial number of the toy
	 * @param name of the toy
	 * @param brand of the toy
	 * @param price of the toy
	 * @param avaliableCount is the number of toys available
	 * @param ageAppropriate is the minimum age the toy should be played with
	 */
	public Toys(int serialNo, String name, String brand, double price, 
			int avaliableCount, String ageAppropriate) {
		
	}

	/**
	 * getter for serial number
	 * @return
	 */
	public int getSerialNo() {
		return serialNo;
	}

	/**
	 * getter for the name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter for the brand
	 * @return
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * getter for the price
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * getter for toy count
	 * @return
	 */
	public int getAvaliableCount() {
		return avaliableCount;
	}

	/**
	 * getter for the age the toy should be sold to
	 * @return
	 */
	public String getAgeAppropriate() {
		return ageAppropriate;
	}
	
	/**
	 * to string method that returns a formatted return for the file
	 * @return formatted output
	 */
	public String format() {
		return serialNo + ";" + name + ";" + brand + ";" + price + ";" + 
				avaliableCount + ";" + ageAppropriate;
	}

	
	
}
