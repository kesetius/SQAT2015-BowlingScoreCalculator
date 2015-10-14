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
		boolean strike = false;
		
		for( Frame frame : this.frames) {
			
			if( strike == true ) {
				sum += frame.score()
				strike = false;				
			}
			
			if( frame.isStrike() )
				strike = true;
			sum += frame.score();
		}
			
		return sum;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
}
