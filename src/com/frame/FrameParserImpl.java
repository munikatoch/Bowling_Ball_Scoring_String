package com.frame;

import com.roll.Roll;

public class FrameParserImpl implements FrameParser {

	private Frame[] frame;

	public FrameParserImpl() {
		frame = new Frame[totalFrames];
	}

	@Override
	public Frame[] frameParser(Roll[] roll) {
		int i, numberOfRolls = 0;
		for (i = 0; i < totalFrames && numberOfRolls < roll.length; i++) {
			frame[i] = getFrame(numberOfRolls, roll);
			numberOfRolls += frame[i].isStrike() ? 1 : 2;
		}
		return frame;
	}

	@Override
	public Frame getFrame(int numberOfRolls, Roll[] roll) {
		Roll rollOne = roll[numberOfRolls];
		if (rollOne.getNumberOfKnockedPins() == 10) {
			Frame frame = new Frame(rollOne);
			return frame;
		}

		if (numberOfRolls + 1 >= roll.length) {
			Frame frame = new Frame(rollOne, Roll.zero());
			return frame;
		}

		Roll rollTwo = roll[numberOfRolls + 1];
		if (rollOne.getNumberOfKnockedPins() + rollTwo.getNumberOfKnockedPins() == 10) {
			Frame frame = new Frame(rollOne, rollTwo, true);
			return frame;
		}

		Frame frame = new Frame(rollOne, rollTwo);
		return frame;
	}

}
