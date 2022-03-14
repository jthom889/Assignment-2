package mru.tsc.controller;

/**
 * this class is the superclass for all toys
 * @author Jonah Thompson
 *
 */
public abstract class Toys {

	//parameters of the toys object
	private long serialNo;
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
	public Toys(long serialNo, String name, String brand, double price, int avaliableCount, String ageAppropriate) {
		 this.serialNo = serialNo;
	     this.name = name;
	     this.brand = brand;
	     this.price = price;
	     this.avaliableCount = avaliableCount;
	     this.ageAppropriate = ageAppropriate;
	}

	/**
	 * getter for serial number
	 * @return
	 */
	public long getSerialNo() {
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
	 * @param decrement availableCount by 1
	 */
	public void decrementStock() {
		this.avaliableCount--;
	}

	/**
	 * getter for the age the toy should be sold to
	 * @return
	 */
	public String getAgeAppropriate() {
		return ageAppropriate;
	}
	
	@Override
	/**
	 * to string method that returns a formatted return for the file
	 * @return formatted output
	 */
	public String toString() {
        return "Serial Number: " + serialNo + ", Name: " + name + ", Brand: " + brand + ", Price: " + price
                + ", Available Count: " + avaliableCount + ", Age Appropriate: " + ageAppropriate;
    }

	/**
	 * Formatting for Toys
	 * @return toys to user
	 */
	public String Format() {
		return String.format("%d;%s;%s;%f;%d;%s", this.serialNo, this.name, this.brand, this.price, this.avaliableCount, this.ageAppropriate);
	}
}
