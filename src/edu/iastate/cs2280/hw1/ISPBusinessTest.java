package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ISPBusinessTest {

	private static Town town;
	
	@BeforeEach
	void setUp() throws Exception {
		
		try {
			town = new Town("ISP4x4.txt");	
		}
		catch (FileNotFoundException e){
			fail("FileNotFound");
		}
	}

	@Test
	final void testUpdatePlain() {
		Town townNew = ISPBusiness.updatePlain(town);
		int length = townNew.getLength();
		int width = townNew.getWidth();
		assertEquals(length, town.getLength());
		assertEquals(width, town.getWidth());
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < width; c++) {
				TownCell townCell = town.grid[r][c];
				TownCell townCellNew = townCell.next(townNew);
				assertEquals(townCellNew.who(), townNew.grid[r][c].who());
			}
		}
	}

	@Test
	final void testGetProfit() {
		assertEquals(ISPBusiness.getProfit(town), 1);
	}

}
