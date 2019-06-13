package com.game;

import java.util.Scanner;

import com.frame.Frame;
import com.frame.FrameParser;
import com.frame.FrameParserImpl;
import com.roll.Roll;
import com.roll.RollParser;
import com.roll.RollsParserImpl;
import com.score.Score;

public class BowlingGame {

	private FrameParser frParser;
	private RollParser rParser;
	private Score score;

	public BowlingGame() {
		frParser = new FrameParserImpl();
		rParser = new RollsParserImpl();
		score = new Score();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rolls : ");
		String rolls = sc.next();
		BowlingGame bGame = new BowlingGame();
		bGame.bowling(rolls);
		sc.close();
	}

	public void bowling(String rolls) {
		Roll[] roll = rParser.rollParser(rolls);
		Frame[] frame = frParser.frameParser(roll);
		int totalScore = score.calculateScore(frame);
		System.out.println(totalScore);
	}
}
