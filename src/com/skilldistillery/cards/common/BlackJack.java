package com.skilldistillery.cards.common;

import java.util.Scanner;


public class BlackJack {

	public static void main(String[] args) {
		
		//Welcome Message
		System.out.println("Welcome to the Blackjack table!");
		
		//Create our deck
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		//Create a deck for the player
		Deck playerDeck = new Deck();
		
		//Create a deck for the dealer
		Deck dealerDeck = new Deck();
		
		
		double playerMoney = 100.00;
		
		Scanner userInput = new Scanner(System.in);
		
		//Game Loop
		while(playerMoney > 0) {
			//Play on!
			//Take player's bet
			System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
			double playerBet = userInput.nextDouble();
			if(playerBet > playerMoney) {
				System.out.println("You cannot bet more than you have.  It appears"+
				" you're gambling beyond your means.  Time to leave friendo");
				break;
			}
			//dealer is pushy.  hidden logic to actually leave table with winnings
			
			if(playerBet == 0.50) {
				System.out.println("Enjoy your winnings gambler.  We hope to see you again.");
				System.exit(0);
			}
			
			boolean endRound = false;
			
			//Start Dealing cards
			//Player gets two
			playerDeck.draw(playingDeck);
			playerDeck.draw(playingDeck);
			
			//Dealer gets two cards
			dealerDeck.draw(playingDeck);
			dealerDeck.draw(playingDeck);
			
			while(true) {
				System.out.println("Your hand: ");
				System.out.println(playerDeck.toString());
				System.out.println("Your hand is valued at: " + playerDeck.cardsValue());
				
				//Display Dealer hand
				System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
				
				//Prompt player hit/stay
				System.out.println("(1)Hit or (2)Stay?");
				int response = userInput.nextInt();
				//hit logic
				if(response == 1) {
					playerDeck.draw(playingDeck);
					System.out.println("You draw a:" + playerDeck.getCard(playerDeck.deckSize()-1).toString() );
					
					//bust if > 21
					if(playerDeck.cardsValue() > 21) {
						System.out.println("Player busts.  Player hand at: " + playerDeck.cardsValue());
						playerMoney -= playerBet;
						endRound = true;
						break;
						
					}
				}
				
				//stay logic
				if(response == 2) {
					break;
				}
				
			}
			
			//Reveal Dealer hand
			System.out.println("Dealer Hand: " + dealerDeck.toString());
			//check if dealer hand > player hand
			if((dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false) {
				System.out.println("Dealer wins.");
				playerMoney -= playerBet;
				endRound = true;
			}
			
			//Dealer hits at or below 16, stands at 17
			while((dealerDeck.cardsValue() < 17) && endRound == false) {
				dealerDeck.draw(playingDeck);
				System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
				
			}
			//Display total dealer hand value
			System.out.println("Dealer's hand is: " + dealerDeck.cardsValue());
			//Determine if dealer busted
			if((dealerDeck.cardsValue() > 21) && endRound == false) {
				System.out.println("Dealer busts!  Player wins!");
				playerMoney += playerBet;
				endRound = true;
			}
			
			//Determine a push
			if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("Push");
				endRound = true;
			}
			//victory hand
			if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("You win the hand!");
				playerMoney += playerBet;
				endRound = true;
			}
			//losing hand
			else if(endRound == false) {
				System.out.println("You lost the hand.");
				playerMoney -= playerBet;
				endRound = true;
			}
			
			//return cards to deck
			playerDeck.moveAllToDeck(playingDeck);
			dealerDeck.moveAllToDeck(playingDeck);
			System.out.println("End of hand.");
		}
		
		System.out.println("Game over!  You are out of money.  Sorry friendo");
	}

}
