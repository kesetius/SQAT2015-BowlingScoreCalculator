package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	public BowlingGame bg;
	
	
	private void initializeGame10Frames() {
		this.bg.addFrame( new Frame(1,5) );
		this.bg.addFrame( new Frame(3,6) );
		this.bg.addFrame( new Frame(7,2) );
		this.bg.addFrame( new Frame(3,6) );
		this.bg.addFrame( new Frame(4,4) );
		this.bg.addFrame( new Frame(5,3) );
		this.bg.addFrame( new Frame(3,3) );
		this.bg.addFrame( new Frame(4,5) );
		this.bg.addFrame( new Frame(8,1) );
		this.bg.addFrame( new Frame(2,6) );	
	}
	
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
	
	@Test
	public void testAddFrame_1_1() {
		this.bg = new BowlingGame();
		this.bg.addFrame( new Frame(1,5) );
		assertEquals( 1, bg.getFrameCount());
	}
	
	@Test
	public void testAddFrame_2_2() {
		this.bg = new BowlingGame();
		this.bg.addFrame( new Frame(1,5) );
		this.bg.addFrame( new Frame(3,6) );
		assertEquals( 2, bg.getFrameCount());
	}
	
	@Test
	public void testAddFrame_10_10() {
		this.bg = new BowlingGame();
		this.initializeGame10Frames();
		assertEquals( 10, bg.getFrameCount());	
	}
	
	@Test
	public void testComputeGameScore_81_81() {
		this.bg = new BowlingGame();
		this.initializeGame10Frames();
		assertEquals( 81, bg.score() );
	}
	
	@Test
	public void testIsStrike_100_true() {
		Frame frame = new Frame( 10, 0);
		assertEquals( true, frame.isStrike() );
	}
	
	@Test
	public void testIsTrike_91_false() {
		Frame frame = new Frame( 9, 1);
		assertEquals( false, frame.isStrike() );	
	}
	
	
	
	

}
