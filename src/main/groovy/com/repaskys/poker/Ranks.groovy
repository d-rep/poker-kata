package com.repaskys.poker

/**
 * Represents the different Poker hand rankings.
 * "No Pairs" and "High Card" are the same, but the former is returned after 
 * checking for pairs, and the latter when evaluating for every hand ranking
 */
enum Ranks {
   STRAIGHT_FLUSH,
   FOUR_OF_A_KIND,
   FULL_HOUSE,
   FLUSH,
   STRAIGHT,
   THREE_OF_A_KIND,
   TWO_PAIRS,
   ONE_PAIR,
   NO_PAIRS,
   HIGH_CARD;
}
