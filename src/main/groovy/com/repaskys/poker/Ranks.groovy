package com.repaskys.poker

/**
 * Represents the different Poker hand rankings.
 * "No Pairs" and "High Card" are the same, but the former is returned after 
 * checking for pairs, and the latter when evaluating for every hand ranking
 */
enum Ranks {
   HIGH_CARD("high card"),
   NO_PAIRS(""),
   ONE_PAIR("one pair"),
   TWO_PAIRS("two pairs"),
   THREE_OF_A_KIND("three of a kind"),
   STRAIGHT("a straight"),
   FLUSH("a flush"),
   FULL_HOUSE("a full house"),
   FOUR_OF_A_KIND("four of a kind"),
   STRAIGHT_FLUSH("straight flush");

   String text

   Ranks(String text) {
      this.text = text
   }
}
