package com.skilldistillery.cards.common;


import java.util.ArrayList;
	import java.util.InputMismatchException;
	import java.util.List;
	import java.util.Scanner;

	public class BlackJackApp {

	  public static void main(String[] args) {
	    BlackJackApp bj = new BlackJackApp();
	    bj.run();
	  }
	  //run app
	  void run() {
	    Deck deck = new Deck();
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Welcome.  Would you like to play a round of Blackjack? "+
	    " 1.  Yes, 2.  No");
	    
	    try {
			int selection = sc.nextInt();
	      if(selection > 2 || selection < 1) {
	        throw new InputMismatchException();
	      }
	      
	      List<Card> hand = new ArrayList<>(numCards);
	      int totalValue = 0;
	      for(int i = 0; i < numCards; i++) {
	        Card c = deck.dealCard();
	        totalValue += c.getValue();
	        hand.add(c);
	      }
	      printHandAndValue(hand, totalValue);
	    }
	    catch (InputMismatchException e) {
	      System.out.println("That is not a valid number of cards.");
	    }
	    finally {
	      sc.close();
	    }
	  }
	  
	  private void printHandAndValue(List<Card> hand, int value) {
	    for (Card card : hand) {
	      System.out.println(card);
	    }
	    System.out.println("Total value: " + value);
	  }

	}


