package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		BlackJackApp bj = new BlackJackApp();
		bj.run();
	}

	private void intro() {
		System.out.print("Would you like to play a round of Blackjack yes(1) or no(2)? ");
		Scanner sc = new Scanner(System.in);
		int reply = sc.nextInt();

		if (reply == 1) {

		} else
			System.exit(0);
	}

	
}
