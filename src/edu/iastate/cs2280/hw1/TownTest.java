package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownTest {

	private static Town randTown;
	private static Town fileTown;

	@BeforeEach
	void setUp() throws Exception {
		randTown = new Town(4, 4);	
		try {
			fileTown = new Town("ISP4x4.txt");			
		}
		catch (FileNotFoundException e){
			fail("FileNotFound");
		}
	}

	@Test
	final void testGetWidth() {
		assertEquals(randTown.getWidth(), 4);
	}

	@Test
	final void testGetLength() {
		assertEquals(randTown.getLength(), 4);
	}

	@Test
	final void testRandomInitANDtoString() {
		randTown.randomInit(10);
		assertEquals(fileTown.toString(), randTown.toString());
	}

}
