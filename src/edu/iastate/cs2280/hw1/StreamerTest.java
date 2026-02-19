package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StreamerTest {

	private static Town town;
	private static TownCell townCell;

	@BeforeEach
	void setUp() throws Exception {
		try {
			town = new Town("ISP4x4.txt");
			townCell = new Streamer(town, 2, 1);
			
		}
		catch (FileNotFoundException e){
			fail("FileNotFound");
		}
	}
	
	@Test
	void whoTest() {
		assertEquals(townCell.who(), State.STREAMER);
	}
	
	@Test
	void nextTest() {
		TownCell newTownCell = townCell.next(town);
		assertEquals(newTownCell.who(), State.OUTAGE);
		assertEquals(newTownCell.row, 2);
		assertEquals(newTownCell.col, 1);
		assertEquals(newTownCell.plain, town);
	}

}
