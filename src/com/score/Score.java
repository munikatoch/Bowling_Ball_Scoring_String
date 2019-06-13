package com.score;

import com.frame.Frame;

public class Score {

	final int totalFrames = 10;

	public int calculateScore(Frame[] frame) {
		int i, score = 0;
		for (i = 0; i < totalFrames; i++) {
			if (frame[i].isStrike()) {
				score += frame[i].getTotalKnockedPinsInFrame() + getStrikeBonus(i + 1, frame);
			} 
			else if (frame[i].isSpare()) {
				score += frame[i].getTotalKnockedPinsInFrame() + getSpareBonus(i + 1, frame);
			} 
			else {
				score += frame[i].getTotalKnockedPinsInFrame();
			}
		}
		return score;
	}

	private int getSpareBonus(int frameNumber, Frame[] frame) {
		return frame[frameNumber].getNumberOfKnockedPinsInRollOne();
	}

	private int getStrikeBonus(int frameNumber, Frame[] frame) {
		if (frame[frameNumber].isStrike()) {
			return frame[frameNumber].getTotalKnockedPinsInFrame()
					+ frame[frameNumber + 1].getNumberOfKnockedPinsInRollOne();
		}
		return frame[frameNumber].getTotalKnockedPinsInFrame();
	}

}
