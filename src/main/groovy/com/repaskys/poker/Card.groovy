package com.repaskys.poker

import com.repaskys.poker.Suit

@Immutable
class Card {

   private static final List<String> CARD_VALUES = ["2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"]

   // Create a standard 52-card deck, where the key would be "2C" for the Two of Clubs
   public static final Map<String, Card> DECK

   static {
      DECK = [:]
      CARD_VALUES.each{ cardValue ->
         Suit.each { suit ->
            String suitCharacter = suit.toString()
            String cardAbbr = cardValue + suitCharacter
            DECK[cardAbbr] = Card.create(cardAbbr)
         }
      }
   }

   /**
    * This is the face value of the card. 2-9, T for a "Ten", J for "Jack", Q for "Queen", K for "King", and A for "Ace."
    */
   String value
   Suit suit

   /**
    * This accepts a 2-character abbreviation of the card with the face value and then the suit, such as "2C" for the Two of Clubs.
    */
   public static Card create(String abbr) {
      return new Card(value: abbr[0], suit: abbr[1])
   }
}
