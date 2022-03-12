package mru.tsc.model;

/**
 * this class sets up the board game toy
 * @author Jonah
 *
 */
public class Puzzles extends Toys {

	//declaring the needed parameter
		private String puzzleType;
		
		
		/**
		 * this constructor creates the toy of type figure
		 * @param s is the serial number
		 * @param n is the name of the toy
		 * @param b is the brand of the toy
		 * @param p is the price of the toy
		 * @param aC is the available count of the toy
		 * @param aA is the age appropriate number for the toy
		 * @param puzzle type of the puzzle
		 */
		public Puzzles(int s, String n, String b, double p, int aC, String aA, String puzzleType) {
			super(s, n, b, p, aC, aA);
			this.puzzleType = puzzleType;
		}


		/**
		 * getter for classification
		 * @return the classification of the figure
		 */
		public String getPuzzleType() {
			return puzzleType;
		}


		/**
		 * setter for classification
		 * @param classification of the figure
		 */
		public void setPuzzleType(String puzzleType) {
			this.puzzleType = puzzleType;
		}
		
		/**
		 * to string method that returns a formatted return for the file
		 * @return formatted output
		 */
		public String format() {
			return getSerialNo() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";" + 
					getAvaliableCount() + ";" + getAgeAppropriate() + ";" + puzzleType;
		}
		
}
