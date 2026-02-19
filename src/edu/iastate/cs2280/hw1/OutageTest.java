package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

class OutageTest {

	private static Town town;
	private static TownCell townCell;

	@BeforeEach
	void setUp() throws Exception {
		try {
			town = new Town("ISP4x4.txt");
			townCell = new Outage(town, 0, 0);
		}
		catch (FileNotFoundException e){
			fail("FileNotFound");
		}
	}
	
	@Test
	void whoTest() {
		assertEquals(townCell.who(), State.OUTAGE);
	}
	
	@Test
	void nextTest() {
		TownCell newTownCell = townCell.next(town);
		assertEquals(newTownCell.who(), State.EMPTY);
		assertEquals(newTownCell.row, 0);
		assertEquals(newTownCell.col, 0);
		assertEquals(newTownCell.plain, town);
	}

}
