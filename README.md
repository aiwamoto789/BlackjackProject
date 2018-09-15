## Blackjack Project

## Week 3 Skill Distillery Weekend Homework

This program runs a game of blackjack with a single player and dealer.

## Program Overview

The program begins by asking if the user if they would like to play a game of 
blackjack.  If the game starts, the dealer then deals cards from the deck in this order: player (face-down), dealer (face-down), player (face-up), dealer (face-up).

The player then gets to view their two cards.  The program displays both the suit and value (2-10, Jack, Queen, King, Ace) and asks the player if they would like to hit or stay.  

If the player selects hit, they are dealt another card face-up from the top of the deck.  If the player busts (their total hand value is greater than 21) then the player loses.  If not, the player has the option to stay, or hit again.  This option continues until the player selects stay, or the player's hand busts.  The player automatically loses on a bust. 

Once the player stays, the dealer reveals their hand and either stays (if the dealer's hand value is >= 17) or hits.  The dealer does not continue to hit if the dealer's hand total becomes 17 or greater.  If the dealer's hand remains lower than the player's, the player wins.  If the dealer busts, the player wins.  

## Techniques Used

## Lessons Learned 