package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	@Test
	public void testFrame_34_34() {
		Frame frame = new Frame( 3, 4 );
		int[] expected = new int[2];
		expected[0] = 3;
		expected[1] = 4;
		assertArrayEquals( expected, frame.getThrowValues());
	}
	
	public void testFrameScore() {
		
		Frame frame = new Frame( 2,3 );
		assertEquals( 5, frame.score());
		
	}
	

}
