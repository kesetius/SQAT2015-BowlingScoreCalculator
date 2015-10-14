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
	
	@Test
	public void testStrikeScore_94_94() {
		this.bg = new BowlingGame();
		this.bg.addFrame( new Frame(10,0) );
		this.bg.addFrame( new Frame(3,6)  );
		this.bg.addFrame( new Frame(7,2)  );
		this.bg.addFrame( new Frame(3,6)  );
		this.bg.addFrame( new Frame(4,4)  );
		this.bg.addFrame( new Frame(5,3)  );
		this.bg.addFrame( new Frame(3,3)  );
		this.bg.addFrame( new Frame(4,5)  );
		this.bg.addFrame( new Frame(8,1)  );
		this.bg.addFrame( new Frame(2,6)  );
		
		assertEquals( 94, this.bg.score());
		
	}
	
	@Test
	public void isSpare_19_true() {
		Frame frame = new Frame ( 1, 9 );
		assertEquals( true, frame.isSpare() );
	}
	
	@Test
	public void isSpare_18_false() {
		Frame frame = new Frame ( 1, 8 );
		assertEquals( false, frame.isSpare() );
	}
	
	@Test
	public void isSpare_100_false() {
		Frame frame = new Frame ( 10, 0 );
		assertEquals( false, frame.isSpare() );
	}

	@Test
	public void testSpareScore_88_88() {
		this.bg = new BowlingGame();
		this.bg.addFrame( new Frame(1,9) );
		this.bg.addFrame( new Frame(3,6)  );
		this.bg.addFrame( new Frame(7,2)  );
		this.bg.addFrame( new Frame(3,6)  );
		this.bg.addFrame( new Frame(4,4)  );
		this.bg.addFrame( new Frame(5,3)  );
		this.bg.addFrame( new Frame(3,3)  );
		this.bg.addFrame( new Frame(4,5)  );
		this.bg.addFrame( new Frame(8,1)  );
		this.bg.addFrame( new Frame(2,6)  );
		
		assertEquals( 88, this.bg.score());
	}
	
	@Test
	public void testStrikeFollowedBySpare_103_103() {
		this.bg = new BowlingGame();
		this.bg.addFrame( new Frame(10,0) );
		this.bg.addFrame( new Frame(4,6)  );
		this.bg.addFrame( new Frame(7,2)  );
		this.bg.addFrame( new Frame(3,6)  );
		this.bg.addFrame( new Frame(4,4)  );
		this.bg.addFrame( new Frame(5,3)  );
		this.bg.addFrame( new Frame(3,3)  );
		this.bg.addFrame( new Frame(4,5)  );
		this.bg.addFrame( new Frame(8,1)  );
		this.bg.addFrame( new Frame(2,6)  );
		assertEquals( 103, this.bg.score());	
	}
	
	@Test
	public void testSubSequentFrame_14_14() {
		Frame frame = new Frame( 5, 3 );
		frame.addSubSequent( new Frame( 1,4 ) );
		int[] expected = new int[2];
		expected[0] = 1;
		expected[1] = 4;
		assertArrayEquals( expected, frame.getSubSequent().getThrowValues() );
	}
	
	@Test
	public void testStrikeFrameScore_19_19() {
		Frame frame = new Frame( 10,0 );
		frame.addSubSequent( new Frame(3,6) );
		assertEquals(19,frame.score());	
	}
	
	@Test
	public void twoStrikesInARowFirstsScore_27_27() {
		Frame frame1 = new Frame( 10,0 );
		Frame frame2 = new Frame( 10,0 );
		Frame frame3 = new Frame( 7,2 );
		frame1.addSubSequent( frame2 );
		frame2.addSubSequent( frame3 );	
		assertEquals( 27, frame1.score());

	}
	
	
}
