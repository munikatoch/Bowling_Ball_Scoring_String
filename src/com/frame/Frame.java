package com.frame;

import com.roll.Roll;

public class Frame {

	private Roll one;
	private Roll two;

	private boolean strike = false;
	private boolean spare = false;

	public Frame(Roll one) {
		this.one = one;
		this.two = Roll.zero();
		this.strike = true;
	}

	public Frame(Roll one, Roll two, boolean spare) {
		this.one = one;
		this.two = two;
		this.spare = spare;
	}

	public Frame(Roll one, Roll two) {
		this.one = one;
		this.two = two;
	}

	public int getNumberOfKnockedPinsInRollOne() {
		return one.getNumberOfKnockedPins();
	}

	public int getTotalKnockedPinsInFrame() {
		return one.getNumberOfKnockedPins() + two.getNumberOfKnockedPins();
	}

	public boolean isSpare() {
		return spare;
	}

	public boolean isStrike() {
		return strike;
	}
}
