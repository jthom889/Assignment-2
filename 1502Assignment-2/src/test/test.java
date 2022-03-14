package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.exceptions.ClassificationException;
import mru.tsc.exceptions.PuzzleException;
import mru.tsc.exceptions.SizeException;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;

class test {

	@Test
	/**
	 * This tests if animal toy is same
	 * @throws SizeException
	 */
	void testAnimalConstructor() throws SizeException {
		Animals obj = new Animals(2222222222L, "ABC", "DEF", 10.89, 4, "4-7", "Plastic", 'M');
		assertEquals(obj.getAvaliableCount(), 4, "Available count should be 4");
		assertEquals(obj.getName(), "ABC", "Name should be ABC");
		assertEquals(obj.getSerialNo(), 2222222222L, "Serial number for animal not set properly");
		assertEquals(obj.getMaterial(), "Plastic", "Material not set properly");
		
		// check for SizeException now
		Exception exception = assertThrows(SizeException.class, () -> {
	        new Animals(2222222222L, "ABC", "DEF", 10.89, 4, "4-7", "Plastic", 'F');
	    });

	    String expectedMessage = "Size has to be one of S, M or L";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	/**
	 * This tests if puzzle toy is the same
	 * @throws PuzzleException
	 */
	void testPuzzleConstructor() throws PuzzleException {
		Puzzles obj = new Puzzles(2222222222L, "Puzzle1", "DEF", 10.89, 10, "4-7", 'M');
		assertEquals(obj.getAvaliableCount(), 10, "Available count should be 10");
		assertEquals(obj.getName(), "Puzzle1", "Name should be Puzzle1");
		assertEquals(obj.getSerialNo(), 2222222222L, "Serial number for puzzle not set properly");
		
		// check for PuzzleTypeException now
		Exception exception = assertThrows(PuzzleException.class, () -> {
	        new Puzzles(2222222222L, "Figure1", "DEF", 10.89, 10, "4-7", 'Q');
	    });

	    String expectedMessage = "Puzzle has to be of type M, T, C, L, or R";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	/**
	 * This tests if figure toy is the same
	 * @throws ClassificationException
	 */
	void testFigureConstructor() throws ClassificationException {
		Figures obj = new Figures(2222222222L, "Figure1", "DEF", 0.89, 1, "4-7", 'A');
		assertEquals(obj.getAvaliableCount(), 1, "Available count should be 1");
		assertEquals(obj.getName(), "Figure1", "Name should be Figure1");
		assertEquals(obj.getSerialNo(), 2222222222L, "Serial number for puzzle not set properly");
		obj.decrementStock();
		assertEquals(obj.getAvaliableCount(), 0, "Available count should be 0");

		// check for PuzzleTypeException now
		Exception exception = assertThrows(ClassificationException.class, () -> {
	        new Figures(2222222222L, "Figure1", "DEF", 10.89, 10, "4-7", 'Q');
	    });

	    String expectedMessage = "Classification can only be A, D or H";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	/**
	 * This test if board game is the same
	 */
	void testBoardGameConstructor() {
		BoardGames obj = new BoardGames(2222222222L, "Board Game1", "DEF", 89.12, 10, "4-7", "4-8", "ABC,NOAH");
		assertEquals(obj.getAvaliableCount(), 10, "Available count should be 10");
		assertEquals(obj.getName(), "Board Game1", "Name should be Figure1");
		assertEquals(obj.getSerialNo(), 2222222222L, "Serial number for puzzle not set properly");
		assertEquals(obj.getMin(), 4, "Min Players should be 4");
		assertEquals(obj.getMax(), 8, "Min Players should be 8");
		String [] expected = {"ABC", "NOAH"};
		assertArrayEquals(obj.getDesigners().toArray(), expected);
	}
	
	@Test
	/**
	 * This tests if formatting for each toy category is the same
	 * @throws Exception
	 */
	void testFormat() throws Exception {
        BoardGames bg = new BoardGames(2222222222L, "Board Game1", "DEF", 89.12, 10, "4-7", "4-8", "ABC,NOAH");
        Figures figure = new Figures(2222222222L, "Figure1", "DEF", 0.89, 1, "4-7", 'A');
        Puzzles puzzle = new Puzzles(2222222222L, "Puzzle1", "DEF", 10.89, 10, "4-7", 'M');
        Animals animal = new Animals(2222222222L, "ABC", "DEF", 10.89, 4, "4-7", "Plastic", 'M');
        assertEquals(bg.Format(), "2222222222;Board Game1;DEF;89.120000;10;4-7;4-8;ABC,NOAH");
        assertEquals(figure.Format(), "2222222222;Figure1;DEF;0.890000;1;4-7;A");
        assertEquals(puzzle.Format(), "2222222222;Puzzle1;DEF;10.890000;10;4-7;M");
        assertEquals(animal.Format(), "2222222222;ABC;DEF;10.890000;4;4-7;Plastic;M");
    }
}
