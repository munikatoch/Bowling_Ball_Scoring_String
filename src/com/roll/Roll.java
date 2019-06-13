package com.roll;

public class Roll {

	private int numberOfKnockedPins;

	public Roll(int numberOfKnockedPins) {
		this.numberOfKnockedPins = numberOfKnockedPins;
	}

	public int getNumberOfKnockedPins() {
		return numberOfKnockedPins;
	}

	public static Roll zero() {
		return new Roll(0);
	}
}
