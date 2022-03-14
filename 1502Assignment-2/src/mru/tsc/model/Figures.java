package mru.tsc.model;

import mru.tsc.controller.Toys;
import mru.tsc.exceptions.ClassificationException;

public class Figures extends Toys {

	//variable declared
    private Classification classification;
    
    /**
     * used enum for the figure classification of toy which is either
     * Action, Doll, or Historic
     * String value declared with Classification taking value as parameter 
     * @author Jonah
     *
     */
    enum Classification {
        Action("Action"),
        Doll("Doll"),
        Historic("Historic");
        
        private String value;
        private Classification(String value) {
            this.value = value;
        }
        
        @Override
        /**
         * Overriding toString method that returns value
         */
        public String toString() {
            return this.value;
        }
    }
    
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
    public Figures(long s, String n, String b, double p, int aC, String aA, char classification) throws ClassificationException {
    
        super(s, n, b, p, aC, aA);

    	switch (classification) {
        case 'A':
            this.classification = Classification.Action;
            break;
        case 'D':
            this.classification = Classification.Doll;
            break;
        case 'H':
            this.classification = Classification.Historic;
            break;
        default:
			throw new ClassificationException("Classification can only be A, D or H");
    	}
    }
    


    @Override
    /**
     * Overriding toString method that returns to user Figure and classification of toy
     */
	public String toString() {
		return "Category: Figures, " + super.toString() + ", Classification: " + this.classification;
	}
    
    /**
	 * Formatting for Figure
	 */
	@Override
	public String Format() {
		return String.format("%s;%c", super.Format(), this.classification.toString().charAt(0));
	}
}