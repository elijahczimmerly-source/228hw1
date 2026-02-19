package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResellerTest {

	private static Town town;
	private static TownCell townCell;

	@BeforeEach
	void setUp() throws Exception {
		try {
			town = new Town("ISP4x4.txt");
			townCell = new Reseller(town, 0, 1);
			
		}
		catch (FileNotFoundException e){
			fail("FileNotFound");
		}
	}
	
	@Test
	void whoTest() {
		assertEquals(townCell.who(), State.RESELLER);
	}
	
	@Test
	void nextTest() {
		TownCell newTownCell = townCell.next(town);
		assertEquals(newTownCell.who(), State.EMPTY);
		assertEquals(newTownCell.row, 0);
		assertEquals(newTownCell.col, 1);
		assertEquals(newTownCell.plain, town);
	}

}
