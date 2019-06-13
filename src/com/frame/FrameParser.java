package com.frame;

import com.roll.Roll;

public interface FrameParser {
	final int totalFrames = 12;

	Frame[] frameParser(Roll[] roll);

	Frame getFrame(int numberOfRolls, Roll[] roll);
}
