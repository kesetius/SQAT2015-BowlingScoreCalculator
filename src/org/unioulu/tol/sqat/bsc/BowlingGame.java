package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public int getFrameCount() {
		return this.frames.size();
	}
	
	public void addFrame(Frame frame){
		this.frames.add( frame);
	}
		
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		//to be implemented
		int sum = 0;
		boolean strikeOnHold = false;
		boolean spareOnHold  = false;
		
		for( Frame frame : this.frames) {
			
			if( strikeOnHold == true ) {
				sum += frame.score();
				strikeOnHold = false;				
			}
			
			if( spareOnHold == true ) {
				sum += frame.getThrowValues()[0];
				spareOnHold = false;
			}			
			sum += frame.score();			
			if( frame.isStrike() )
				strikeOnHold = true;
			if( frame.isSpare() )
				spareOnHold = true;
		}
			
		return sum;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
}
