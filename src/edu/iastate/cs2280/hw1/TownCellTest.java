package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownCellTest {
	private static Town town;
	private static TownCell townCell;

	@BeforeEach
	void setUp() throws Exception {
		try {
			town = new Town("ISP4x4.txt");
			townCell = new Casual(town, 1, 2);
			
		}
		catch (FileNotFoundException e){
			fail("FileNotFound");
		}
	}
	
	@Test
	void censusTest() {
		townCell.census(TownCell.nCensus);
		assertEquals(TownCell.nCensus[TownCell.RESELLER], 2);
		assertEquals(TownCell.nCensus[TownCell.EMPTY], 1);
		assertEquals(TownCell.nCensus[TownCell.CASUAL], 0);
		assertEquals(TownCell.nCensus[TownCell.OUTAGE], 3);
		assertEquals(TownCell.nCensus[TownCell.STREAMER], 2);
	}
	
}
