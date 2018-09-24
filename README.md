## Blackjack Project

## Week 3 Skill Distillery Weekend Homework

This program runs a game of blackjack with a single player and dealer.

## Program Overview

The program begins by welcoming the user to the blackjack table.  The game starts and the player has an initial betting pool
of $100. The game begins by asking the player how much they would like to bet.  A bet higher than their betting pool results
in the player being asked to leave.  Hidden logic allows the player to leave if they bet $0.50, otherwise the pushy dealer
assumes the player wishes to continue.

The dealer then deals two cards each to the player and dealer, with one of the dealer's cards hidden.

The program displays both the suit and value (2-10, Jack, Queen, King, Ace) and asks the player if they would like to hit or stay.  

If the player selects hit, they are dealt another card face-up from the top of the deck.  If the player busts (their total hand value is greater than 21) then the player loses.  If not, the player has the option to stay, or hit again.  This option continues until the player selects stay, or the player's hand busts.  The player automatically loses on a bust. 

Once the player stays, the dealer reveals their hand and either stays (if the dealer's hand value is >= 17) or hits.  The dealer does not continue to hit if the dealer's hand total becomes 17 or greater.  If the dealer's hand remains lower than the player's, the player wins.  If the dealer busts, the player wins.  

The game continues to loop until either the player runs out of money to bet, or uses the hidden logic to leave the table.

## Techniques Used

ArrayList, getters, setters, while loops, if loops, enums, randomizer, moveTo, scanner

## Lessons Learned 

soft aces are harder to code than previously expected.  Used loop logic, ArrayLists, and enums. 
