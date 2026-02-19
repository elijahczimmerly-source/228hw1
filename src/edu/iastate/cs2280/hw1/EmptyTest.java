package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyTest {

	private static Town town;
	private static TownCell townCell;

	@BeforeEach
	void setUp() throws Exception {
		try {
			town = new Town("ISP4x4.txt");
			townCell = new Empty(town, 1, 0);
			
		}
		catch (FileNotFoundException e){
			fail("FileNotFound");
		}
	}
	
	@Test
	void whoTest() {
		assertEquals(townCell.who(), State.EMPTY);
	}
	
	@Test
	void nextTest() {
		TownCell newTownCell = townCell.next(town);
		assertEquals(newTownCell.who(), State.CASUAL);
		assertEquals(newTownCell.row, 1);
		assertEquals(newTownCell.col, 0);
		assertEquals(newTownCell.plain, town);
	}

}
