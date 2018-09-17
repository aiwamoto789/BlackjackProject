package com.skilldistillery.cards.common;

public class Player {

	private String name;

	private Card[] hand = new Card[10];

	private int numCards;

	public Player(String aName) {
		this.name = aName;

		this.emptyHand();

	}

public void emptyHand() {

	public boolean addCard(Card aCard) {
		if (this.numCards == 10) {
			System.err.printf("%s's hand already has 10 cards; " +
			"cannot add another\n", this.name);
			System.exit(1);
		}
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandSum() <= 21);
}
	
}

	public int getHandSum() {
		int handSum = 0;
		int Rank;
		int numAces = 0;

		for (int c = 0; c < this.numCards; c++) {
			Rank = this.hand[c].getRank();

			if (Rank == 1) {
				numAces++;
				handSum += 11;
			} else if (Rank > 10) {
				handSum += 10;
			} else {
				handSum += Rank;
			}
		}

		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
		return handSum;
	}

	public void printHand(boolean showFirstCard) {
		System.out.println("%s's card: \n" + this.name);
		for (int c = 0; c < this.numCards; c++) {
			if (c == 0 && !showFirstCard) {
				System.out.println("  [hidden]");
			} else {
				System.out.printf("  %s\n", this.hand[c].toString());
			}
		}
	}
}