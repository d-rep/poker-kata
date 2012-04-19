package com.repaskys.poker

import com.repaskys.poker.Suit

@Immutable
class Card {

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
