package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	@Test
	public void testFrame() {
		Frame frame = new Frame( 3, 4 );
		int[] expected = new int[] {3,4}; 
		assertEquals( expected, frame.getThrowValues());
	}
	
	

}
