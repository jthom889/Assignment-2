package mru.tsc.model;

import mru.tsc.controller.Toys;
import mru.tsc.exceptions.PuzzleException;

public class Puzzles extends Toys {
	 //puzzleType variable declared
	PuzzleType puzzleType;
	
	/**
	 * used enum for what type of puzzle it is which is
	 * either Mechanical, Cryptic, Logic, Trivia, or Riddle.
	 * value variable declared with PuzzleType taking value as parameter
	 * @author Jonah
	 *
	 */
    enum PuzzleType {
        Mechanical("Mechanical"), 
        Cryptic("Cryptic"), 
        Logic("Logic"), 
        Trivia("Trivia"),
        Riddle("Riddle");
        
        String value;
        private PuzzleType(String value) {
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
     * Gives user option on what type of puzzle they want which is
     * either Mechanical, Trivia, Cryptic, Logic, or Riddle
     * @param sn - serial number of toy 
     * @param toyName - name of toy
     * @param toyBrand - brand of toy
     * @param price - price of toy
     * @param toyAmount - Amount of toys available
     * @param ageGroup - tells what age group is for toy
     * @param puzzleType - tells user what type of puzzle it is
     */
    public Puzzles(long s, String n, String b, double p, int aC, String aA, char puzzleType) throws PuzzleException {
        super(s, n, b, p, aC, aA);
    	switch (puzzleType) {
    	 case 'M':
             this.puzzleType = PuzzleType.Mechanical;
             break;
         case 'T':
             this.puzzleType = PuzzleType.Trivia;
             break;
         case 'C':
             this.puzzleType = PuzzleType.Cryptic;
             break;
         case 'L':
             this.puzzleType = PuzzleType.Logic;
             break;
         case 'R':
             this.puzzleType = PuzzleType.Riddle;
             break;
         default:
        	 throw new PuzzleException("Puzzle has to be of type M, T, C, L, or R");
    }
    }

    @Override
    /**
     * Overriding toString method that returns and tells user puzzle and puzzle type 
     */
    public String toString() {
        return "Category: Puzzle, " + super.toString() + ", Puzzle Type: " + this.puzzleType;
    }
    
    /**
	 * Formatting for Puzzle
	 */
	@Override
	public String Format() {
		return String.format("%s;%c", super.Format(), this.puzzleType.toString().charAt(0));
	}
}
