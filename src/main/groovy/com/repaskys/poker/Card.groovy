package com.repaskys.poker

import com.repaskys.poker.Suit

@Immutable
class Card implements Comparable<Hand> {

   private static final List<String> CARD_VALUES = ["2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"]

   // Create a standard 52-card deck, where the key would be "2C" for the Two of Clubs
   public static final Map<String, Card> DECK

   static {
      def deck = [:]
      CARD_VALUES.each{ cardValue ->
         Suit.each { suit ->
            String suitCharacter = suit.toString()
            String cardAbbr = cardValue + suitCharacter
            deck[cardAbbr] = Card.create(cardAbbr)
         }
      }
      DECK = deck.asImmutable()
   }

   /**
    * This is 1-character representing the face value of the card. 2-9, T for a "Ten", J for "Jack", Q for "Queen", K for "King", and A for "Ace."
    */
   String value

   Suit suit

   /**
    * The face value of the card, translated to a number, which can be used to determine straights and the high-card.
    * (This can be unintuitive, since a card with a face value of "2" will have a rank of 0 because it's the lowest rank.)
    */
   Integer rank

   /**
    * This accepts a 2-character abbreviation of the card with the face value and then the suit, such as "2C" for the Two of Clubs.
    */
   public static Card create(String abbr) {
      return new Card(value: abbr[0], suit: abbr[1], rank: CARD_VALUES.indexOf(abbr[0]))
   }

   public int compareTo(otherCard) {
      int val = 0
      if(this.rank > otherCard.rank) {
         val = 1
      } else if(this.rank < otherCard.rank) {
         val = -1
      }
      val
   }
}
