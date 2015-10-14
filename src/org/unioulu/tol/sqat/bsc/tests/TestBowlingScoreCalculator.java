package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	public BowlingGame bg = new BowlingGame();
	
	
	@Test
	public void testFrame_34_34() {
		Frame frame = new Frame( 3, 4 );
		int[] expected = new int[2];
		expected[0] = 3;
		expected[1] = 4;
		assertArrayEquals( expected, frame.getThrowValues());
	}
	
	@Test
	public void testFrameScore_23_5() {
		Frame frame = new Frame( 2,3 );
		assertEquals( 5, frame.score());
	}
	
	public void testAddFrame() {
		
		this.bg.addFrame( new Frame(1,5) );
		assertEquals( 1, bg.getFrameCount());
		
		
	}
	
	

}
