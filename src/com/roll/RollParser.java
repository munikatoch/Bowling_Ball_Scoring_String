package com.roll;

public interface RollParser {
	final char strike = 'X';
	final char knock = '/';
	final char emptyRoll = '-';

	int getPoints(int pos, String rolls);

	Roll[] rollParser(String rolls);
}
