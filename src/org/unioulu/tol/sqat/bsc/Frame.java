package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	public int[] getThrowValues() {
		int[] anArray = new int[2];
		anArray[0] = this.firstThrow;
		anArray[1] = this.secondThrow;
		return anArray;
	}
	
	//the score of a single frame
	public int score(){
		return (this.firstThrow + this.secondThrow);
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		if( this.firstThrow == 10 )
			return true;
		return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		
		if( this.firstThrow + this.secondThrow == 10
			&& !this.isStrike())
			return true;
		return false;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		//to be implemented
		return false;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}
}
