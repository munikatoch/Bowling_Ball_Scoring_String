package com.roll;

public class RollsParserImpl implements RollParser {

	private Roll[] roll;

	@Override
	public Roll[] rollParser(String rolls) {
		int i, len = rolls.length();
		roll = new Roll[len];
		for (i = 0; i < len; i++) {
			roll[i] = createRoll(i, rolls);
		}
		return roll;
	}

	public Roll createRoll(int pos, String rolls) {
		int points = getPoints(pos, rolls);
		Roll roll = new Roll(points);
		return roll;
	}

	@Override
	public int getPoints(int pos, String rolls) {
		char c = rolls.charAt(pos);
		if (c == strike) {
			return 10;
		} 
		else if (c == knock) {
			return 10 - getPoints(pos - 1, rolls);
		} 
		else if (c == emptyRoll) {
			return 0;
		} 
		else {
			return Character.getNumericValue(c);
		}

	}

}
