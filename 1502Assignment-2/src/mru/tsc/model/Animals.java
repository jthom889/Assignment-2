package mru.tsc.model;

import mru.tsc.controller.Toys;
import mru.tsc.exceptions.SizeException;

public class Animals extends Toys {
	//variables declared
	private String material;
	private Size size;
	
	/**
	 * used enum for size of animals which is either Small, Medium, or Large
	 * sizes variable declared with Size taking sizes as parameter
	 */
	enum Size {
		Small ("Small"), 
		Medium ("Medium"), 
		Large ("Large");
        private String sizes;
        private Size(String sizes) {
            this.sizes = sizes;
        }
       
        @Override
        /**
         * Overriding toString method that returns sizes
         */
        public String toString(){
            return this.sizes;
        }
	};
    /**
     * this constructor creates the toy of Animal
     * Gives user option what size animal they want
     * @param serialNum - serial number of toy 
     * @param toyName - name of toy
     * @param toyBrand - brand of toy
     * @param price - price of toy
     * @param toyAmount - Amount of toys available
     * @param ageGroup - tells what age group is for toy
     * @param material - material of the animal
     * @param size - size of the animal
     */
    public Animals(long s, String n, String b, double p, int aC, String aA, String material, char size) throws SizeException {
        super(s, n, b, p, aC, aA);
        this.material = material;
        switch (size) {
		case 'S':
			this.size = Size.Small;
			break;
		case 'M':
			this.size = Size.Medium;
			break;
		case 'L':
			this.size = Size.Large;
			break;
		default:
			throw new SizeException("Size has to be one of S, M or L");
	}
    }
    /**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}
    
    @Override
    /**
     * method that returns and tells user animal, material, and size
     */
    public String toString() {
        return "Category: Animal, " + super.toString() + ", Material: " + this.material + ", Size: " + this.size;
    }
    
    /**
	 * Formatting for animal
	 */
    @Override
	public String Format() {
		return String.format("%s;%s;%s", super.Format(), this.material, this.size.toString().charAt(0));
	}
}

